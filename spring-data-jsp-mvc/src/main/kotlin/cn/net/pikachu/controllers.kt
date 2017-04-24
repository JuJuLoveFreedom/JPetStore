package cn.net.pikachu

import org.springframework.stereotype.Controller

/**
 * Created by pikachu on 2017/4/24.
 */
class UserController(
        var accountService: AccountService
){

}

class AdminController(
        var statisticsService: StatisticsService
){

}