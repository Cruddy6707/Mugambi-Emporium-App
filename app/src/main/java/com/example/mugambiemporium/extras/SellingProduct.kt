package com.example.mugambiemporium.extras

class SellingBook {
    //unique IDs
    var sellerbookid: String? = null
    var bookid: String? = null
    var sellerid: String? = null

    //Book integer details
    var quantities = 0
    var sellingprice = 0
    var rentingprice = 0
    var deliverycharges = 0

    //Book string details
    var title: String? = null
    var author: String? = null
    var description: String? = null
    var category: String? = null

    //Links
    var thumbnail: String? = null
    var preview: String? = null

    constructor() {}
    constructor(
        bookid: String?,
        sellerbookid: String?,
        sellerid: String?,
        quantities: Int,
        sellingprice: Int,
        rentingprice: Int,
        deliverycharges: Int,
        title: String?,
        author: String?,
        description: String?,
        category: String?,
        thumbnail: String?,
        preview: String?
    ) {
        this.bookid = bookid
        this.sellerbookid = sellerbookid
        this.sellerid = sellerid
        this.quantities = quantities
        this.sellingprice = sellingprice
        this.rentingprice = rentingprice
        this.deliverycharges = deliverycharges
        this.title = title
        this.author = author
        this.description = description
        this.category = category
        this.thumbnail = thumbnail
        this.preview = preview
    }
}
