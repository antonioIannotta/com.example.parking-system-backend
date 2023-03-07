package it.unibo.lss.smart_parking.framework.utils

import io.ktor.server.testing.*
import org.junit.jupiter.api.Test

class MongoConnectionTest {

    @Test
    fun `test connection to mongo atlas database and user collection existence`() = testApplication {
        val mongoClient = getUserMongoClient()
        getUserCollection(mongoClient)
    }

    @Test
    fun `test connection to mongo atlas database and parking slot collection existence`() = testApplication {
        val mongoClient = getParkingSlotMongoClient()
        getParkingSlotCollection(mongoClient)
    }

}