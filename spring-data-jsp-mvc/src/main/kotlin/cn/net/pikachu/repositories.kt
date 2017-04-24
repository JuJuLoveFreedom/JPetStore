package cn.net.pikachu

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

/**
 * Created by pikachu on 2017/4/22.
 */
@Repository
interface UserRepository : JpaRepository<User,Long>{
    fun findByUsernameAndPassword(username:String,password:String):User?
}
@Repository
interface AccountRepository : JpaRepository<Account, Long>
@Repository
interface CategoryRepository : JpaRepository<Category, Long>
@Repository
interface ItemRepository : JpaRepository<Item, Long>
@Repository
interface OrderRepository : JpaRepository<Order,Long>
@Repository
interface CommentRepository : JpaRepository<Comment,Long>
@Repository
interface CartRepository : JpaRepository<Cart,Long>
@Repository
interface SupplierRepository : JpaRepository<Supplier,Long>
@Repository
interface PayInfoRepository : JpaRepository<PayInfo,Long>
@Repository
interface LogisticsInfoRepository : JpaRepository<LogisticsInfo,Long>