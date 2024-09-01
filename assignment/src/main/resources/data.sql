-- ProductTypes
INSERT INTO
    product_types (product_type_name)
SELECT *
FROM (
  VALUES
	('Bread'),
	('Vegetable'),
	('Beer')
 )
WHERE NOT EXISTS (
  SELECT NULL
  FROM product_types
);

-- Breads
INSERT INTO
	breads (price, product_type_id)
SELECT *
FROM (
  VALUES
	(1.5, 1)
 )
WHERE NOT EXISTS (
  SELECT NULL
  FROM breads
);

INSERT INTO
	bread_discounts (bread_id, max_age, extra_quantity)
SELECT *
FROM (
  VALUES
	(1, 1, 0),
	(1, 3, 1),
	(1, 6, 2)
 )
WHERE NOT EXISTS (
  SELECT NULL
  FROM bread_discounts
);

-- Vegetables
INSERT INTO
	vegetables (price, product_type_id)
	SELECT *
FROM (
  VALUES
	(0.01, 2)
 )
WHERE NOT EXISTS (
  SELECT NULL
  FROM vegetables
);

INSERT INTO
	vegetable_discounts (vegetable_id, minimum_weight, discount_percentage)
	SELECT *
FROM (
  VALUES
	(1, 0, 0.05),
	(1, 100, 0.07),
	(1, 500, 0.10)
 )
WHERE NOT EXISTS (
  SELECT NULL
  FROM vegetable_discounts
);

-- Beers
INSERT INTO
	beers (price, brand, product_type_id)
	SELECT *
FROM (
  VALUES
	(1.5, "Belgium", 3),
	(1.5, "Dutch", 3),
	(1.5, "German", 3)
 )
WHERE NOT EXISTS (
  SELECT NULL
  FROM beers
);

INSERT INTO
	beer_discounts (beer_id, bottles_required, discount_amount)
	SELECT *
FROM (
  VALUES
	(1, 6, 1),
	(2, 6, 2),
	(3, 6, 3)
 )
WHERE NOT EXISTS (
  SELECT NULL
  FROM beer_discounts
);
