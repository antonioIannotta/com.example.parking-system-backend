package it.unibo.lss.smart_parking.use_cases

import it.unibo.lss.smart_parking.entity.UserCredentials
import it.unibo.lss.smart_parking.interface_adapter.model.request.SignUpRequestBody
import it.unibo.lss.smart_parking.interface_adapter.model.response.ServerResponseBody
import it.unibo.lss.smart_parking.interface_adapter.model.response.SigningResponseBody
import it.unibo.lss.smart_parking.interface_adapter.model.response.UserInfoResponseBody

interface UserUseCases {

    fun login(credentials: UserCredentials, tokenSecret: String): SigningResponseBody
    fun createUser(signUpRequestBody: SignUpRequestBody, tokenSecret: String): SigningResponseBody
    fun recoverPassword(mail: String, tokenSecret: String): ServerResponseBody
    fun getUserInfo(id: String): UserInfoResponseBody
    fun changePassword(userId: String, newPassword: String, currentPassword: String?): ServerResponseBody
    fun deleteUser(userId: String): ServerResponseBody

    fun validateCredentials(credentials: UserCredentials): Boolean

    //utility function: check if there is a user with this mail in the collection
    fun userExists(mail: String): Boolean

}