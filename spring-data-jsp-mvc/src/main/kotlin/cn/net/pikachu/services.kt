package cn.net.pikachu

/**
 * Created by pikachu on 2017/4/22.
 */
/**
 * Question 1
 * 怎么保证User和Account的id一样
 */
interface AccountService{
    // 登录
    fun signIn(user: User):Boolean
    // 注册
    fun signUp(user: User):User
    // 找回密码
    fun findPassword(id: Long,verificationCode:String):Boolean
    // 获取个人信息
    fun getUserInfoById(id:Long):Account
    // 修改密码
    fun updatePassword(password:String,id: Long)
    // 修改地址
    fun updateAddress(address: Address,id: Long)
    // 修改基本信息（真实姓名 昵称 QQ 电话 电子邮件）
    fun updateBaseInfo(accountBaseInfo: AccountBaseInfo)
    // 修改个人喜好（语言 宠物 快递）
    fun updateProfile(profile: Profile)
    // 添加收货地址
    fun addDeliveryAddress(deliveryAddress: DeliveryAddress,id: Long)
    // 删除收货地址
    fun removeDeliveryAddress(deliveryAddressId:Long,id: Long)
    // 修改收货地址
    fun updateDeliveryAddress(deliveryAddress: DeliveryAddress)
    // 获取喜欢的商品
    fun getFavItems(id: Long):List<Item>
}
interface GoodsService{
    // 获取商品信息
    fun getItemByItemId(id: Long):Item
    // 通过名称搜索商品
    fun searchItemByName(name:String):List<Item>
    // 修改商品信息
    fun updateItem(item: Item)
}
interface CartService{
    // 添加到购物车
    fun addItemToCart(itemId:Long,id: Long)
    // 清空购物车
    fun clearCart(id: Long)
    // 修购买的商品数量
    fun updateItemQuantity(lineItemId: Long,quantity:Int,id: Long)
    // 从购物车中移除商品
    fun removeItemFromCart(lineItemId: Long,id: Long)
}
interface OrderService{
    // 生成订单
    fun makeOrder(lineItemIdList:List<Long>,deliveryAddressId: Long,id: Long)
    // 取消订单
    fun cancelOrder(orderId:Long,id: Long)
    fun getAllOrder(id: Long):List<Order>
}
interface PayService{
    // 为某个订单付款
    fun payForOrder(orderId: Long,id: Long)
    // 申请退款
    fun refund(orderId: Long,id: Long)
}
interface ExpressService{
    // 获取物流信息
    fun getLogisticsInfosByOrderId(orderId: Long):List<LogisticsInfo>
    // 催单
    fun remindShipment(orderId: Long)
}
interface DeliveryAddressService{
    fun getAllDeliveryAddress(id: Long):List<DeliveryAddress>
    fun addDeliveryAddress(deliveryAddress: DeliveryAddress):DeliveryAddress
    fun deleteDeliveryAddress(deliveryAddressId: Long)
    fun updateDeliveryAddress(deliveryAddress: DeliveryAddress)
}
interface SupplierService{
    fun getAllSupplier():List<Supplier>
    fun updateSupplier(supplier: Supplier)
    fun deleteSupplier(supplierId:Long)
    fun addSupplier(supplier: Supplier)
}

/**
 * 此处需要讨论统计应该展示什么信息
 */
interface StatisticsService{
    // 获取今日的销售情况
    fun getTodaySales()
    // 获取最近n天的销售情况
    fun getLatestSales(n:Int)
}

class AccountServiceImpl(
        var userRepository: UserRepository,
        var accountRepository: AccountRepository,
        var verificationCodeRepository: VerificationCodeRepository,
        var deliveryAddressRepository: DeliveryAddressRepository
) : AccountService {
    override fun signIn(user: User): Boolean {
        var user=userRepository.findByUsernameAndPassword(user.username,user.password)
        return user!=null
    }

    override fun signUp(user: User):User {
       return userRepository.save(user)
    }

    override fun findPassword(id: Long,code:String): Boolean {
       var verificationCode=verificationCodeRepository.findOne(id)
        if(verificationCode==null){
            return false
        }
        return verificationCode.code==code
    }

    override fun getUserInfoById(id: Long): Account {
        return accountRepository.findOne(id)
    }

    override fun updatePassword(password: String, id: Long) {
        var user=userRepository.findOne(id)
        user.password=password
        userRepository.save(user)

    }

    override fun updateAddress(address: Address, id: Long) {
        var account=accountRepository.findOne(id)
        account.address=address
        accountRepository.save(account)
    }

    override fun updateBaseInfo(accountBaseInfo: AccountBaseInfo) {
        var account=accountRepository.findOne(accountBaseInfo.id)
        account.accountBaseInfo=accountBaseInfo
        accountRepository.save(account)
    }

    override fun updateProfile(profile: Profile) {
       var account=accountRepository.findOne(profile.id)
        account.profile=profile
        accountRepository.save(account)
    }

    override fun addDeliveryAddress(deliveryAddress: DeliveryAddress, id: Long) {
       var account=accountRepository.findOne(id)
        account.deliveryAddressList.add(deliveryAddress)
        accountRepository.save(account)
    }

    override fun removeDeliveryAddress(deliveryAddressId: Long, id: Long) {
        deliveryAddressRepository.delete(deliveryAddressId)
    }

    override fun updateDeliveryAddress(deliveryAddress: DeliveryAddress) {
        var deliveryAddress=deliveryAddressRepository.findOne(deliveryAddress.id)
        deliveryAddress=deliveryAddress
        deliveryAddressRepository.save(deliveryAddress )
    }

    override fun getFavItems(id: Long): List<Item> {
      return accountRepository.findOne(id).profile.favItems

    }
}