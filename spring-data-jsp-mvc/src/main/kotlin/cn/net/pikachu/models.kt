package cn.net.pikachu

/**
 * Created by pikachu on 2017/4/22.
 */
import java.math.BigDecimal
import java.sql.Timestamp
import javax.persistence.*

@Entity
data class User(
        @Id
        @GeneratedValue
        var id:Long,
        var username:String,
        var password:String,
        @OneToOne
        var account: Account
)
@Embeddable
@NoArg
data class Address(
        var country:String,
        var province:String,
        var city:String,
        var street:String,
        var zip:String
)
@Entity
data class Account(
        @Id
        @GeneratedValue
        var id:Long,
        // 用户等级
        @OneToOne
        var level: Level,
        var accountBaseInfo: AccountBaseInfo,
        @Embedded
        var address: Address,
        @OneToOne
        var profile: Profile,
        @OneToOne
        var user: User,
        @OneToMany
        var deliveryAddressList: MutableList<DeliveryAddress>,
        @OneToOne
        var cart: Cart,
        @OneToMany
        var orders: MutableList<Order>
)
@Entity
data class AccountBaseInfo(
        @Id
        var id: Long,
        var phone:String,
        var qq:String,
        var email:String,
        var name:String,
        var nickname:String
)
@Entity
data class Profile(
        @Id
        var id:Long,
        var language:String,
        // 喜欢的宠物列表
        @OneToMany
        var favItems:MutableList<Item>,
        @OneToMany
        var favExpress: MutableList<Express>
)
@Entity
@NoArg
data class Category(
        @Id
        @GeneratedValue
        var id: Long,
        var name: String,
        var des:String,
        @OneToMany
        var items: MutableList<Item>
)
@Entity
data class Item(
        @Id
        var id:Long,
        var name: String,
        // 原价
        var listPrice:BigDecimal,
        // 实际价格
        var unitPrice:BigDecimal,
        // 库存
        var quantity:Quantity,
        @OneToOne
        var category: Category,
        @OneToMany
        var colorList:MutableList<ColorList>,
        var des:String,
        var detail: String,
        var status:String,
        var img:String,
        var star:BigDecimal,
        // 已售出的数量
        var number:Int
)
@Entity
data class Quantity(
        @Id
        var id: Long,
        var quantity:Int
)
@Entity
data class ColorList(
        @Id
        @GeneratedValue
        var id: Long,
        var color:String,
        var img: String
)
@Entity
data class Express(
        @Id
        var id: Long,
        var name:String,
        var phone:String
)
@Entity
data class Level(
        @Id
        var id:Long,
        var name:String,
        var img:String
)
@Entity
data class Order(
        @Id
        var id: Long,
        @Embedded
        var deliveryAddress: DeliveryAddress,
        @OneToOne
        var payInfo: PayInfo,
        @OneToMany
        var items:MutableList<LineItem>,
        @OneToMany
        var logisticsInfo: MutableList<LogisticsInfo>,
        // 生成日期
        var date:Timestamp = Timestamp(System.currentTimeMillis()),
        var status:String = "未付款"
)
// 收货地址
@Entity
data class DeliveryAddress(
        @Id
        var id: Long,
        @Embedded
        var address: Address,
        var phone:String,
        // 收货人
        var receiver:String
)
@Entity
data class PayInfo(
        @Id
        var id: Long,
        // 金额
        var amount:BigDecimal,
        var status:String,
        var payType:String,
        var cardNumber:String
)
@Entity
data class LineItem(
        @Id
        var id: Long,
        @OneToOne
        var item: Item,
        // 用户购买的数量
        var quantity: Int,
        // 用户实际付款
        var price:BigDecimal,
        // 商品的可选属性
        var attr: String
)
// 物流信息
@Entity
data class LogisticsInfo(
        @Id
        @GeneratedValue
        var id: Long,
        @OneToOne
        var express: Express,
        var time:Timestamp,
        var place:String,
        var status:String,
        @OneToOne
        var lineItem: LineItem
)
// 评论
@Entity
data class Comment(
        @Id
        @GeneratedValue
        var id:Long,
        @OneToOne
        var user: User,
        @OneToOne
        var item: Item,
        var comment:String,
        @OneToMany
        var img:MutableList<CommentImgList>,
        var star:BigDecimal,
        // 商品可选属性 如颜色
        var attr:String
)
@Entity
data class CommentImgList(
        @Id
        @GeneratedValue
        var id: Long,
        var img: String
)
@Entity
data class Cart(
        @Id
        @GeneratedValue
        var id: Long,
        @OneToOne
        var user: User,
        @OneToMany
        var lineItems: MutableList<LineItem>,
        var total:BigDecimal
)
@Entity
data class Supplier(
        @Id
        @GeneratedValue
        var id: Long,
        @OneToMany
        var items: MutableList<Item>,
        // 是否有货
        var status: String,
        var name: String,
        @Embedded
        var address: Address,
        var phone: String
)
@Entity
data class VerificationCode(
        @Id
       var id: Long,
       var code:String
)