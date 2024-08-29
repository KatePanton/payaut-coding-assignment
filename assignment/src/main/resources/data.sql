-- ProductTypes

INSERT INTO
    product_types (product_type_name)
VALUES
	('Bread'),
	('Vegetable'),
	('Beer');

-- Breads
INSERT INTO
	breads (price, product_type_id)
VALUES
	(1.5, 1);

INSERT INTO
	bread_discounts (bread_id, days_old, discount_percentage)
VALUES
	(1, 0, 0),
	(1, 1, 0),
	(1, 2, 0.33),
	(1, 3, 0.33),
	(1, 4, 0.66),
	(1, 5, 0.66),
	(1, 6, 0.66);

-- Vegetables
INSERT INTO
	vegetables (price, product_type_id)
VALUES
	(1, 2);

INSERT INTO
	vegetable_discounts (vegetable_id, minimum_weight, maximum_weight, discount_percentage)
VALUES
	(1, 0, 100, 0.05),
	(1, 101, 500, 0.07),
	(1, 501, 10000, 0.10);

-- Beers
INSERT INTO
	beers (price, brand, product_type_id)
VALUES
	(0.5, "Belgium", 3),
	(0.5, "Dutch", 3),
	(0.5, "German", 3);

INSERT INTO
	beer_discounts (beer_id, bottles_required, discount_amount)
VALUES
	(1, 6, 3),
	(2, 6, 2),
	(3, 6, 4);