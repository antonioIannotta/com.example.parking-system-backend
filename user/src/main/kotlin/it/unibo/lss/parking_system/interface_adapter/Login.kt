package it.unibo.lss.parking_system.interface_adapter

import it.unibo.lss.parking_system.entity.UserCredentials
import it.unibo.lss.parking_system.interface_adapter.model.ResponseCode
import it.unibo.lss.parking_system.interface_adapter.model.response.SigningResponseBody
import it.unibo.lss.parking_system.interface_adapter.utils.generateJWT
import it.unibo.lss.parking_system.use_cases.getUserInfo
import it.unibo.lss.parking_system.use_cases.validateCredentials
import java.util.*

fun login(credentials: UserCredentials, tokenSecret: String): SigningResponseBody {

    return if (Objects.isNull(getUserInfo(credentials.email)))
        SigningResponseBody(ResponseCode.USER_NOT_FOUND.code, "User not found")
    else if (validateCredentials(credentials)) {
        val jwt = generateJWT(credentials.email, tokenSecret)
        SigningResponseBody(null, "success", jwt)
    } else
        return SigningResponseBody(ResponseCode.PASSWORD_ERROR.code, "Wrong password")

}