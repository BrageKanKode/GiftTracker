package AppClasses

class Persons {
    var name: String
    var gift: Gifts
    var budget: Long


    constructor(name: String, gift: Gifts, budget: Long) {
        this.name = name
        this.gift = gift
        this.budget = budget
    }


}