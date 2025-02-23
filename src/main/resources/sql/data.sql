-- insert into warehouse.warehouse (capacity, current_amount_stored, overflow_percentage, id)
-- values (1000, 500, 10, gen_random_uuid()),
--        (2000, 1500, 15, gen_random_uuid()),
--        (1500, 1000, 12, gen_random_uuid());
--
-- -- Insert data into the material table with the corresponding warehouse_id
-- insert into material (selling_price_per_ton, storage_price_per_ton_per_day, id, warehouse_id, description, name, type)
-- values (50, 5, gen_random_uuid(), (select id from warehouse.warehouse limit 1 offset 0), 'Used in construction', 'Gips', 'GP'),
--        (100, 10, gen_random_uuid(), (select id from warehouse.warehouse limit 1 offset 1), 'Derived from petroleum', 'Petcoke', 'PT'),
--        (75, 7, gen_random_uuid(), (select id from warehouse.warehouse limit 1 offset 2), 'Byproduct of steel production', 'SlaK', 'SL'),
--        (120, 12, gen_random_uuid(), (select id from warehouse.warehouse limit 1 offset 0), 'Raw material for steel', 'ijzererts', 'IC'),
--        (90, 9, gen_random_uuid(), (select id from warehouse.warehouse limit 1 offset 1), 'Used in construction', 'Cement', 'CT');
--
-- insert into customer_party (id, address, name)
-- values
--     (gen_random_uuid(), '123 Main St', 'Customer A'),
--     (gen_random_uuid(), '456 Elm St', 'Customer B'),
--     (gen_random_uuid(), '789 Oak St', 'Customer C');
--
-- insert into seller_party (id, address, name)
-- values
--     (gen_random_uuid(), '321 Market St', 'Seller X'),
--     (gen_random_uuid(), '654 Pine St', 'Seller Y'),
--     (gen_random_uuid(), '987 Maple St', 'Seller Z');
--
-- insert into purchase_order (customer_party_id, referenceuuid, seller_party_id, po_number, vessel_number)
-- values
--     ((select id from customer_party limit 1 offset 0), gen_random_uuid(), (select id from seller_party limit 1 offset 0), 'PO12345', 'Vessel001'),
-- ((select id from customer_party limit 1 offset 1), gen_random_uuid(), (select id from seller_party limit 1 offset 1), 'PO12346', 'Vessel002'),
-- ((select id from customer_party limit 1 offset 2), gen_random_uuid(), (select id from seller_party limit 1 offset 2), 'PO12347', 'Vessel003');

insert into order_line (id, description, line_number, material_type, quantity, uom, material_id, purchase_order_referenceuuid)
values
    (gen_random_uuid(), 'Gips', 1, 'GP', 100, 'kt', (select id from material where type = 'GP' limit 1), (select referenceuuid from purchase_order limit 1 offset 0)),
    (gen_random_uuid(), 'Petcoke', 2, 'PT', 200, 'kt', (select id from material where type = 'PT' limit 1), (select referenceuuid from purchase_order limit 1 offset 1)),
    (gen_random_uuid(), 'SlaK', 3, 'SL', 150, 'kt', (select id from material where type = 'SL' limit 1), (select referenceuuid from purchase_order limit 1 offset 2)),
    (gen_random_uuid(), 'Ijzererts', 4, 'IC', 180, 'kt', (select id from material where type = 'IC' limit 1), (select referenceuuid from purchase_order limit 1 offset 0)),
    (gen_random_uuid(), 'Cement', 5, 'CT', 90, 'kt', (select id from material where type = 'CT' limit 1), (select referenceuuid from purchase_order limit 1 offset 1));
