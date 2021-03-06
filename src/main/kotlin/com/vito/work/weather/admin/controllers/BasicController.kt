package com.vito.work.weather.admin.controllers

import com.vito.work.weather.domain.services.LocationService
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import javax.annotation.Resource
import javax.servlet.http.HttpServletRequest

/**
 * Created by lingzhiyuan.
 * Date : 16/4/10.
 * Time : 上午11:47.
 * Description:
 *
 */

@Controller
@RequestMapping("/admin")
open class BasicController {

    @Resource
    lateinit var locationService: LocationService

    @RequestMapping("","/")
    open fun toIndex(): String {
        return "admin/index"
    }

    @RequestMapping("login")
    open fun login(): String {
        return "admin/login"
    }

    @RequestMapping("logout")
    open fun logout(request: HttpServletRequest): String {
        request.logout()
        return "admin/login"
    }

}
