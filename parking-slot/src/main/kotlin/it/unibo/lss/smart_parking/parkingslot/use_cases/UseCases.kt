package it.unibo.lss.smart_parking.parkingslot.use_cases

import io.ktor.http.*
import it.unibo.lss.smart_parking.parkingslot.entity.Center
import it.unibo.lss.smart_parking.parkingslot.entity.ParkingSlot
import kotlinx.serialization.json.JsonObject
import kotlinx.datetime.Instant

/*
Copyright (c) 2022-2023 Antonio Iannotta & Luca Bracchi

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
*/
interface UseCases {
    fun occupyParkingSlot(userId: String, slotId: String, stopEnd: Instant): Pair<HttpStatusCode, JsonObject>
    fun incrementParkingSlotOccupation(userId: String, slotId: String, stopEnd: Instant): Pair<HttpStatusCode, JsonObject>
    fun freeParkingSlot(slotId: String): Pair<HttpStatusCode, JsonObject>
    fun getAllParkingSlotsByRadius(center: Center): List<ParkingSlot>
    fun getParkingSlotList(): List<ParkingSlot>
    fun getParkingSlot(id: String): ParkingSlot?
    fun getParkingSlotOccupiedByUser(userId: String): ParkingSlot?


    fun isTimeValid(actualTime: Instant, previousTime: Instant): Boolean {
        return actualTime > previousTime
    }

}