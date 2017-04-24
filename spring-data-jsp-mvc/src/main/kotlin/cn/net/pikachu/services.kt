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
    fun signUp(user: User)
    // 找回密码
    fun findPassword(username:String,verificationCode:String):Boolean
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
        var userRepository:UserRepository
) : AccountService{
    override fun signIn(user:User): Boolean {
        val user = userRepository.findByUsernameAndPassword(user.username,user.password)
        return user!=null
    }

    override fun signUp(user:User) {
     }

    override fun findPassword(username: String, verificationCode: String): Boolean {
    }

    override fun getUserInfoById(id: Long): {
        throw UnsupportedOperationException("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun updatePassword(password: String, id: Long) {
        throw UnsupportedOperationException("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun updateAddress(address:, id: Long) {
        throw UnsupportedOperationException("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun updateBaseInfo(accountBaseInfo:) {
        throw UnsupportedOperationException("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun updateProfile(profile:) {
        throw UnsupportedOperationException("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun addDeliveryAddress(deliveryAddress:, id: Long) {
        throw UnsupportedOperationException("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun removeDeliveryAddress(deliveryAddressId: Long, id: Long) {
        throw UnsupportedOperationException("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun updateDeliveryAddress(deliveryAddress:) {
        throw UnsupportedOperationException("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getFavItems(id: Long): List<> {
        throw UnsupportedOperationException("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
