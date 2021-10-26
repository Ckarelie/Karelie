package com.karelie.commom.net
import java.io.Serializable
/**
 * @Creator:Karelie
 * @Data: 2021/10/21
 * @TIME: 9:47
 * @Introduce: JSON返回的基本类型
**/
open class BaseResp<T> (
    open val data: T? = null,
    open val errorCode: Int? = null,
    open val errorMsg: String? = null,
    open val error: Throwable? = null,
    ) : Serializable {
        val isSuccess: Boolean
        get() = errorCode == 0
    }

    data class ApiSuccessResponse<T>(val response: T) : BaseResp<T>(data = response)

    class ApiEmptyResponse<T> : BaseResp<T>()

    data class ApiFailedResponse<T>(override val errorCode: Int?, override val errorMsg: String?) : BaseResp<T>(errorCode = errorCode, errorMsg = errorMsg)

    data class ApiErrorResponse<T>(val throwable: Throwable) : BaseResp<T>(error = throwable)