package AppClasses

import java.util.*

class Events {
    var budget: Long? = null
    var date: Date? = null

    constructor(budget: Long?, date: Date) {
        this.budget = budget
        this.date = date
    }
}