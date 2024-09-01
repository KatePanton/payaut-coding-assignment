# Order API call:

### /orders/getOrderWithDiscounts
	[
    	{"beerDiscountRequests": [
    		{brand: String, beerQuantity: Integer}
    	]},

		{"breadDiscountRequests": [
			{breadId: Integer, breadAge: Integer, breadQuantity: Integer}
		]},

		{"vegDiscountRequests": [
			{vegetableId: Integer, vegetableWeight: Integer}
		]}
	]


    [
    	{"beerDiscountRequests": [
    		{"brand": "Belgium", "beerQuantity": 4},
    		{"brand": "Dutch", "beerQuantity": 6},
    		{"brand": "German", "beerQuantity": 8}
    	]},

		{"breadDiscountRequests": [
			{"breadId": 1, "breadAge": 0, "breadQuantity": 2},
			{"breadId": 1, "breadAge": 3, "breadQuantity": 1},
			{"breadId": 1, "breadAge": 6, "breadQuantity": 1}
		]},

		{"vegDiscountRequests": [
			{"vegetableId": 1, "vegetableWeight": 50},
			{"vegetableId": 1, "vegetableWeight": 120},
			{"vegetableId": 1, "vegetableWeight": 600}
		]}
	]
