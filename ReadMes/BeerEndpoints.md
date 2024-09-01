# Beer API calls:

### /beers/addBeer
	{
		price: Number,
		brand: String,
		productTypeName: String
	}

	{
		"price" : 0.5, "brand": "French", "productTypeName": "Beer"
	}

### /beers/addBeerDiscount
    {
	    beerBrand: String,
	    bottlesRequired: Integer,
	    discountAmount: Number
    }

    {
	    "beerBrand": "French", "bottlesRequired": 6, "discountAmount": 1
    }

### /beers/getBeerByBrand
    {
	    brand: String
    }

    {
	    "brand": "Dutch"
    }

### /beers/getAll

    { }

### /beers/getDiscount

	[{
	    brand: String,
	    beerQuantity: Integer
	}]

	[
		{"brand": "Dutch", "beerQuantity": 4},
		{"brand": "Dutch", "beerQuantity": 6},
		{"brand": "German", "beerQuantity": 12},
		{"brand": "German", "beerQuantity": 13}
	]

### /beers/updateBeer
    {
	    price: Number,
	    brand: String,
	    productTypeName: String
    }

    {
	    "price": 2, "brand": "Dutch", "productTypeName": "Beer"
    }

### /beers/updateBeerDiscount
    {
	    beerBrand: String,
	    bottlesRequired: Integer,
	    discountAmount: Number
    }

    {
	    "beerBrand": "Dutch",
	    "bottlesRequired": 6,
	    "discountAmount": 1.5
    }

