package cn.net.pikachu

import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner
/*

@RunWith(SpringRunner::class)
@SpringBootTest
class AccountServiceTest {
    @Autowired
    lateinit var accountService: AccountService
    @Autowired
    lateinit var userRepository: UserRepository
    val address = Address("中国","浑南","长沙","天心区","415129")
    val accountBaseInfo = AccountBaseInfo(0,"15084909943","2931408816","2931408816@qq.com","杨浩","大黄老鼠")
    // 登录
    fun testSignIn_true(user: User){
        val user = User(0,"pikachu","123",)
        val flag =  accountService.signIn(user)
        Assert.assertTrue(flag)
    }
    fun testSignIn_false(user:User){
        val user = User(0,"pikachu","1234",null)
        val flag =  accountService.signIn(user)
        Assert.assertFalse(flag)
    }
    // 注册
    fun testSignUp(user: User){
        val user = User(0,"test","test",null)
        val u = accountService.signUp(user)
        val uu = userRepository.findOne(u.id)
        Assert.assertEquals(uu,u)
    }
    // 找回密码
    fun testFindPassword(username:String,verificationCode:String)
    // 获取个人信息
    fun testGetUserInfoById(id:Long)
    // 修改密码
    fun testUpdatePassword(password:String,id: Long)
    // 修改地址
    fun testUpdateAddress(address: Address,id: Long)
    // 修改基本信息（真实姓名 昵称 QQ 电话 电子邮件）
    fun testUpdateBaseInfo(accountBaseInfo: AccountBaseInfo)
    // 修改个人喜好（语言 宠物 快递）
    fun testUpdateProfile(profile: Profile)
    // 添加收货地址
    fun testAddDeliveryAddress(deliveryAddress: DeliveryAddress,id: Long)
    // 删除收货地址
    fun testRemoveDeliveryAddress(deliveryAddressId:Long,id: Long)
    // 修改收货地址
    fun testUpdateDeliveryAddress(deliveryAddress: DeliveryAddress)
    // 获取喜欢的商品
    fun testGetFavItems(id: Long)
}
*/
