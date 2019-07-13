[---]LRU
LRU(Least Recently Used) 的意思就是近期最少使用算法,它的核心思想就是会优先淘汰那些近期最少使用的缓
    存对象.
1.新数据插入到链表头部; 
2.每当缓存命中（即缓存数据被访问）,则将数据移到链表头部; 
3.当链表满的时候,将链表尾部的数据丢弃.     
LruCache其实使用了LinkedHashMap维护了强引用对象.
总缓存的大小一般是可用内存的 1/8,当超过总缓存大小会删除最少使用的元素,也就是内部LinkedHashMap的头
    部元素.
当使用get()访问元素后,会将该元素更新到LinkedHashMap的尾部.
LrhCache和DisLruCache,分别用于实现内存缓存和硬盘缓存,其核心思想都是LRU缓存算法.

[---]集合
静态数组的长度是固定的,而动态数组的长度是不固定的.
静态数组是在定义时就已经在栈上分配了空间大小,在运行时这个大小不能改变,动态数组的大小是在运行是给定,
    即,运行时在堆上分配一定的存储空间,同时运行时还可以改变其大小.
ArrayList比较适合顺序添加、随机访问的场景.
ArrayList和LinkedList的区别：
    1.ArrayList是实现了基于动态数组的数据结构,LinkedList是基于链表结构.
    2.对于随机访问的get和set方法,ArrayList要优于LinkedList,因为LinkedList要移动指针.
    3.对于新增和删除操作add和remove,LinkedList比较占优势,因为ArrayList要移动数据.
通过Collections.synchronizedList方法把你的ArrayList变成一个线程安全的List,如下:
    List<String> synchronizedList = Collections.synchronizedList(list);
LinkedList 批量添加节点的方法实现了.大体分下面几个步骤：
    1.检查索引值是否合法,不合法将抛出角标越界异常
    2.保存index位置的节点,和index-1位置的节点.
    3.将参数集合转化为数组,循环将数组中的元素封装为节点添加到链表中.
    4.更新链表长度并返回添加true表示添加成功.
二叉树遍历：先序遍历：根左右；中序遍历：左根右；后序遍历：左右根；看任务执行完成没有,也就是两个子节
    点遍历完没有,完成了才会会到父节点；最后进了多少层,就要返回多少次.
深度遍历有前序、中序以及后序三种遍历方法,广度遍历即我们寻常所说的层次遍历.
无论是在遍历树、查找深度、查找最大值都用到了递归,递归在非线性的数据结构中是用得非常多的.

[Else]    
transient为java关键字,防止属性serialization序列化
Context的数量等于Activity的个数 + Service的个数 + 1,这个1为Application
Android规定一个线程只能够拥有一个与自己关联的Looper
N:Handler  1:Looper  1:MessageQueue  M:Message

[---]Android图片中的三级缓存
网络加载,不优先加载,速度慢,浪费流量
本地缓存,次优先加载,速度快
内存缓存,优先加载,速度最快

[---]Activiy生命周期
跳转到当前MainActivity：MainActivity执行：onCreate-->onStart-->onResume
在MainActivity跳转到Dialog模式下的Activity(DialogActivity),执行：onPause-->dialogActivityOnCreate
    -->dialogActivityOnStart-->dialogActivityOnResume,退出DialogActivity,执行：dialogActivityOnPause
    -->onResume-->dialogActivityOnStop-->dialogActivityOnDestroy
在MainActivity跳转到普通Dialog,啥都不执行.
在MainActivity跳转到普通Activity(TestActivity),执行：onPause-->testActivityOnCreate
    -->testActivityOnStart-->testActivityOnResume-->onStop,退出TestActivity,执行：
    oTestActivitynPause-->onRestart-->onStart-->onResume-->oTestActivitynStop-->oTestActivitynDestroy
退出MainActivity：MainActivity执行：onPause-->onStop-->onDestroy    
点击home键就等于跳转到普通Activity中；

[---]接口的意义:规范、扩展、回调
抽象类的意义:(全是为了子类)
       为其子类提供一个公共的类型
       封装子类中得重复内容
       定义抽象方法,子类虽然有不同的实现 但是定义是一致的
       抽象类用来捕捉子类的通用特性
父类的静态方法可以被子类继承,但是不能重写
向上转型：子类对象转为父类,父类可以是接口.公式：Father f = new Son();Father是父类或接口,son是子类.
向下转型：父类对象转为子类.公式：Son s = (Son)f;
子类重写了父类的方法,若通过子类的实例来实现该方法,那么只执行子类的该方法,不会执行父类的该方法,除
    非加上super关键字.
子类没有重写父类的方法,若通过子类的实例来实现该方法,那么就只会执行父类的该方法.
接口和抽象类的区别
    抽象类是对类本质的抽象，表达的是 is a 的关系，比如：BMW is a Car。抽象类包含并实现子类的通用特性，
        将子类存在差异化的特性进行抽象，交由子类去实现。
    而接口是对行为的抽象，表达的是 like a 的关系。比如：Bote-Royce like a Aircraft（像飞行器一样可以
        飞），但其本质上 is a Car。接口的核心是定义行为，即实现类可以做什么，至于实现类主体是谁、是
        如何实现的，接口并不关心。
    如果你关心的是“飞行汽车”这个整体，那么定义抽象类 FlyCar 是个不错的选择；如果你关心的是汽车具备
        “飞行”的行为，那不妨继续沿用前面使用 Aircraft 接口的方案。        

[---]Rxjava
上游可以发送无限个onNext, 下游也可以接收无限个onNext.
当上游发送了一个onComplete后, 上游onComplete之后的事件将会继续发送, 而下游收到onComplete事件之后将不
    再继续接收事件.
当上游发送了一个onError后, 上游onError之后的事件将继续发送, 而下游收到onError事件之后将不再继续接收
    事件.
上游可以不发送onComplete或onError.
最为关键的是onComplete和onError必须唯一并且互斥, 即不能发多个onComplete, 也不能发多个onError, 也不能
    先发一个onComplete, 然后再发一个onError, 反之亦然
调用dispose()并不会导致上游不再继续发送事件, 上游会继续发送剩余的事件.
不带任何参数的subscribe() 表示下游不关心任何事件,你上游尽管发你的数据去吧, 老子可不管你发什么.
带有一个Consumer参数的方法表示下游只关心onNext事件, 其他的事件我假装没看见
比如一个界面需要展示用户的一些信息, 而这些信息分别要从两个服务器接口中获取, 而只有当两个都获取到了之
    后才能进行展示, 这个时候就可以用Zip了;
ObserveOn指定一个观察者在哪个调度器上观察这个Observable,每次调用了ObservableOn选择的调度器之后,都会
    有作用.
SubscribeOn指定Observable自身在哪个调度器上执行,只有第一次SubscribeOn选择的调度器有作用,而后来选择
    的都没有作用.这说明了SubscribeOn这个操作符,与调用的位置无关,而且只有第一次调用时会指定
    Observable自己在哪个调度器执行.    
注意：若在SubscribeOn之前没有调用ObserveOn,那么观察者会在SubscribeOn选择的调度器上,直到ObserveOn选
    择调度器后才会切换到ObservableOn选择的调度器上,都没调用,则默认为主线程.

[---]泛型：
[1]ArrayList<T> al=new ArrayList<T>();指定集合元素只能是T类型
[2]ArrayList<?> al=new ArrayList<?>();集合元素可以是任意类型,这种没有意义,一般是方法中,只是为了
    说明用法
[3]ArrayList<? extends E> al=new ArrayList<? extends E>();
   泛型的限定：
   ? extends E:接收E类型或者E的子类型.
   ? super E:接收E类型或者E的父类型.
?和T都表示不确定的类型  但如果是T的话 函数里面可以对T进行操作
泛型类型在逻辑上可以看成是多个不同的类型,实际上都是相同的基本类型.

[---]数据存储
1 使用SharedPreferences存储数据
2 文件存储数据
3 SQLite数据库存储数据
4 使用ContentProvider存储数据
5 网络存储数据

[---]性能优化
1、内存泄漏memory leak :是指程序在申请内存后,无法释放已申请的内存空间,一次内存泄漏似乎不会有大的影
    响,但内存泄漏堆积的后果就是内存溢出.
2、内存溢出 out of memory :指程序申请内存时,没有足够的内存供申请者使用,或者说,给了你一块存储int类
    型数据的存储空间,但是你却存储long类型的数据,那么结果就是内存不够用,此时就会报错OOM,即所谓的内
    存溢出.
内存泄漏的堆积最终会导致内存溢出
内存管理
为了使垃圾回收器可以正常释放程序所占用的内存,在编写代码的时候就一定要注意尽量避免出现内存泄漏的
    情况(通常都是由于全局成员变量持有对象引用所导致的),并且在适当的时候去释放对象引用.对于大多数
    的应用程序而言,后面其它的事情就可以都交给垃圾回收器去完成了,如果一个对象的引用不再被其它对象所
    持有,那么系统就会将这个对象所分配的内存进行回收.
1.节制地使用Service
    为了能够控制Service的生命周期,Android官方推荐的最佳解决方案就是使用IntentService,
    这种Service的最大特点就是当后台任务执行结束后会自动停止,从而极大程度上避免了Service内存泄漏的可
    能性.
2.当界面不可见时释放内存
    那么我们如何才能知道程序界面是不是已经不可见了呢？其实很简单,只需要在Activity中重写
    onTrimMemory()方法,然后在这个方法中监听TRIM_MEMORY_UI_HIDDEN这个级别,一旦触发了之后就说明用户
    已经离开了我们的程序,那么此时就可以进行资源释放操作了,如下所示：
    @Override
    public void onTrimMemory(int level) {
    	super.onTrimMemory(level);
    	switch (level) {
    	case TRIM_MEMORY_UI_HIDDEN:
    		// 进行资源释放操作
    		break;
    	}
    }
    注意onTrimMemory()方法中的TRIM_MEMORY_UI_HIDDEN回调只有当我们程序中的所有UI组件全部不可见的时候
    才会触发,这和onStop()方法还是有很大区别的,因为onStop()方法只是当一个Activity完全不可见的时候就
    会调用.
    经测试发现,点Back键不会触发onTrimMemory(),点击Home键会触发onTrimMemory(),只要在栈中的Activity
    且该Activity重写了onTrimMemory()方法,就会调用onTrimMemory();
3.避免在Bitmap上浪费内存
    当我们读取一个Bitmap图片的时候,有一点一定要注意,就是千万不要去加载不需要的分辨率.
    在一个很小的ImageView上显示一张高分辨率的图片不会带来任何视觉上的好处,但却会占用我们相当多宝贵
    的内存.
    需要仅记的一点是,将一张图片解析成一个Bitmap对象时所占用的内存并不是这个图片在硬盘中的大小,可能
    一张图片只有100k你觉得它并不大,但是读取到内存当中是按照像素点来算的,比如这张图片是1500*1000像
    素,使用的ARGB_8888颜色类型,那么每个像素点就会占用4个字节,总内存就是1500*1000*4字节,也就是
    5.7M,这个数据看起来就比较恐怖了.
    当在界面显示图片时,需要的内存空间不是按图片的实际大小来计算的,而是按像素点的多少乘以每个像素点
    占用的空间大小来计算的.
集合类
// 通过循环申请Object对象和将申请的对象逐个放入到集合List
List<Object> objectList = new ArrayList<>();        
       for (int i = 0; i < 10; i++) {
            Object o = new Object();
            objectList.add(o);
            o = null;
        }
// 虽释放了集合元素引用的本身：o=null
// 但集合List 仍然引用该对象,故垃圾回收器GC 依然不可回收该对象
解决方案
// 释放objectList
objectList.clear();
objectList=null;
单例模式引用的对象的生命周期 = 应用的生命周期
// 对于 图片资源Bitmap：Android分配给图片的内存只有8M,若1个Bitmap对象占内存较多,当它不再被使用时,
    应调用recycle()回收此对象的像素所占用的内存;最后再赋为null.
Bitmap.recycle();
Bitmap = null;
// 对于动画(属性动画)
// 将动画设置成无限循环播放repeatCount = “infinite”后,在Activity退出时记得停止动画
不是任何情况下都要使用ConstraintLayout,如果布局不复杂不建议用,影响性能
ConstrainLayout(约束布局)只是用来解决复杂的嵌套,不代表完全干掉RelativeLayout, ConstrainLayout的
    onMeasure是比Relativelayout和Linearlayout更耗时的,如果简单布局,不考虑深度嵌套,它的onMeasure就拖
    后腿了, 但是深度嵌套下Constrainlayout的优势就体现出来了.
WebView都会存在内存泄漏的问题,在应用中只要使用一次WebView,内存就不会被释放掉.通常的解决办法就是为
    WebView单开一个进程,使用AIDL与应用的主进程进行通信.
资源对象比如Cursor、File等,往往都用了缓冲,不使用的时候应该关闭它们.把他们的引用置为null,而不关闭
    它们,往往会造成内存泄漏.因此,在资源对象不使用时,一定要确保它已经关闭,通常在finally语句中关
    闭,防止出现异常时,资源未被释放的问题.
很多系统服务需要register和unregister监听器,我们需要确保在合适的时候及时unregister那些监听器.自己手
    动add的Listener,要记得在合适的时候及时remove这个Listener.    
内存抖动：一般指在很短的时间内发生了多次内存分配和释放,严重的内存抖动还会导致应用程序卡顿.内存抖动
    出现原因主要是短时间频繁的创建对象(可能在循环中创建对象),内存为了应对这种情况,也会频繁的进行GC.
    频繁的GC会产生大量的暂停时间,这会导致界面绘制时间减少,从而多次使得绘制一帧的时长超过了16ms,产生
    的现象就是界面卡顿.
 
[---]过度绘制优化：
[1].移除布局中不需要的背景
1.移除Window默认的Background
通常,我们使用的theme都会包含了一个windowBackground,比如某个theme的如下：
<item name="android:windowBackground">@color/background_material_light</item>
然后,我们一般会给布局一个背景,比如:
<android.support.constraint.ConstraintLayout    
...    
android:background="@mipmap/bg">
这就导致了整个页面都会多了一次绘制.
那么其解决办法也很简单,把windowBackground移除掉就可以了,有以下两种方法来解决,随便使用其中一种
    即可：
(1).在theme中设置
    <style name="AppTheme" parent="主题">
        <item name="android:windowBackground">@null</item>
    </style>
(2).在Activity的onCreate()方法中添加：
    getWindow().setBackgroundDrawable(null);
2.移除控件中不需要的背景
[2].将layout层级扁平化
[3].减少透明度的使用
[Else]
GPU:图形处理器(Graphics Processing Unit),又称显示核心、视觉处理器、显示芯片,是一种专门在个人电脑、
    工作站、游戏机和一些移动设备(如平板电脑、智能手机等)上做图像运算工作的微处理器.
CPU:中央处理器(Central Processing Unit)
现在android系统中刷新ui会通过cpu产生数据，然后交给gpu渲染的形式来完成.
CPU和GPU是通过图形驱动层来进行连接的.图形驱动层维护了一个队列,CPU将display list添加到该队列
    中,这样GPU就可以从这个队列中取出数据进行绘制.
FPS:每秒传输帧数(Frames Per Second).
如果画面在60fps则不会感觉到卡顿,每个绘制时长在16ms(1000/60=16.66)以内
V-Sync:垂直同步(Vertical Synchronization),指计算机操作系统的一个功能,作用主要是让显卡的运算和显示器
    刷新率一致,以稳定输出画面的质量.
Android系统每隔16ms发出VSYNC信号,触发对UI进行渲染,如果每次渲染都成功,这样就能够达到流畅的画面所需要
    的60fps.
产生卡顿原因有很多,主要有以下几点：
    布局Layout过于复杂,无法在16ms内完成渲染.
    同一时间动画执行的次数过多,导致CPU或GPU负载过重.
    View过度绘制,导致某些像素在同一帧时间内被绘制多次.
    UI线程中做了稍微耗时的操作.
Profile GPU Rendering(GPU呈现模式分析)
橙色代表处理的时间,是CPU告诉GPU渲染一帧的地方,这是一个阻塞调用,因为CPU会一直等待GPU发出接到命令的
    回复,如果橙色柱状图很高,则表明GPU很繁忙.
红色代表执行的时间,这部分是Android进行2D渲染 Display List的时间.如果红色柱状图很高,可能是由重新提
    交了视图而导致的.还有复杂的自定义View也会导致红的柱状图变高.
蓝色代表测量绘制的时间,也就是需要多长时间去创建和更新DisplayList.如果蓝色柱状图很高,可能是需要重
    新绘制,或者View的onDraw方法处理事情太多.
TraceView是Android SDK中内置的一个工具,它可以加载trace文件,用图形的形式展示代码的执行时间、次数及
    调用栈,便于我们分析.
    
[---]ContentProvider：内容提供者,对外提供数据的操作,contentProvider.notifyChanged(uir)：可以更新数据
ContentResolver：内容解析者,解析ContentProvider返回的数据,Context里面调用
    getContentResolver().query(...)进行查询
ContentObServer:内容监听者,监听数据的改变,contentResolver.registerContentObServer()

[---]Activity启动模式
standard 每启动一个Activity就会在栈顶创建一个新的实例
singleTop 该模式会判断要启动的Activity实例是否位于栈顶,如果位于栈顶直接复用,否则创建新的实例
singleTask 使Activity在整个应用程序中只有一个实例.每次启动Activity时系统首先检查栈中是否存在当前
    Activity实例,如果存在则直接复用,并把当前Activity之上所有实例全部出栈
singleInstance 该模式的Activity会启动一个新的任务栈来管理Activity实例,并且该势力在整个系统中只有一
    个(退出的时候该Activity必须出现一次).
Activity的onNewIntent()方法何时会被调用? 
    前提:ActivityA已经启动过,处于当前应用的Activity堆栈中; 
    当ActivityA的LaunchMode为SingleTop时,如果ActivityA在栈顶,且现在要再启动ActivityA,这时会调用
        onNewIntent()方法 
    当ActivityA的LaunchMode为SingleInstance,SingleTask时,如果已经ActivityA已经在堆栈中,那么此时会调
        用onNewIntent()方法 
    当ActivityA的LaunchMode为Standard时,由于每次启动ActivityA都是启动新的实例,和原来启动的没关系,
        所以不会调用原来ActivityA的onNewIntent方法

[---]service
service中onStartCommand会调用onStart方法
第一种(startService/onStartCommand-->onCreate、stopService/onDestroy)
通过startService启动后,service会一直无限期运行下去,只有外部调用了stopService方法时,该Service才会
    停止运行并销毁.
第一次执行startService会执行onCreate回调,多次startService不会重复执行onCreate回调,但每次都会执行
    onStartCommand回调,执行stopService会执行onDestroy回调,这时再执行stopService,没有日志打印,再执
    行startService,又是第一次.(onStartCommand方法中的startId参数可以看为重复执行次数)
第二种(bindService/onCreate-->onBind-->onServiceConnected、unbindService/onUnbind-->onDestroy)
通过bindService绑定后,service会随着Activity的onDestroy而onDestroy,无论执行多少次bindService,service
    只执行一次onCreate、onBind、onServiceConnected
当unbindService执行后,会执行onUnbind、onDestroy方法,在没有bindService的情况下,无论是第一次执行或
    者再次执行unbindService,都会导致程序会崩溃
如何保证Service不被杀死？
1.onStartCommand方式中,返回START_STICKY
2.提高Service的优先级
    在AndroidManifest.xml文件中对于intent-filter可以通过android:priority = "1000"这个属性设置最高优
    先级,1000是最高值,如果数字越小则优先级越低,同时适用于广播.注：android:priority的取值范围官方文档
    为[-1000,1000],但是可以为2147483647,且动态注册要比静态注册的优先级高.
3.提升Service进程的优先级
    当系统进程空间紧张时,会依照优先级自动进行进程的回收.
    Android将进程分为6个等级,按照优先级由高到低依次为：
    前台进程foreground_app
    可视进程visible_app
    次要服务进程secondary_server
    后台进程hiddena_app
    内容供应节点content_provider
    空进程empty_app
    可以使用startForeground将service放到前台状态,这样低内存时,被杀死的概率会低一些.
4.在onDestroy方法里重启Service
    当service走到onDestroy()时,发送一个自定义广播,当收到广播时,重新启动service.

[---]进程
冒号开头：进程对于这个应用来说是私有的.
小写字符开头：不同应用中的各种组件可以共享一个进程.
开启几个进程会使Application运行几次
Messenger是一种轻量级的IPC(Inter-Process Communication,进程间通信)方案,其底层实现是AIDL

[---]两种方式注册广播：
在代码中动态注册：不是常驻型广播,也就是说广播跟随程序的生命周期.
在Manifest.xml中静态注册：是常驻型,也就是说当应用程序关闭后,如果有信息广播来,程序也会被系统调用,自
    动运行.
有两种方式分别发送两种不同的广播：
通过mContext.sendBroadcast(Intent)或mContext.sendBroadcast(Intent, String)发送的是无序广播(后者加了
    权限);
通过mContext.sendOrderedBroadcast(Intent, String, BroadCastReceiver, Handler, int, String, Bundle)
    发送的是有序广播.
区别：
无序广播：所有的接收者都会接收事件,不可以被拦截,不可以被修改.
有序广播：按照优先级,一级一级的向下传递,接收者可以修改广播数据,也可以终止广播事件.

[---]HTTP
通常来说一个HTTP请求报文由请求行、请求报头、空行、和请求数据4个部分组成.HTTP的响应报文由状态行、消
    息报头、空行、响应正文组成.
HttpClient/HttpURLConnection
无论我们是自己封装的网络请求类还是第三方的网络请求框架都离不开这两个类库
在Android 2.2版本之前,HttpClient拥有较少的bug,因此使用它是最好的选择.
而在Android 2.3版本及以后,HttpURLConnection则是最佳的选择.它的API简单,体积较小,
    因而非常适用于Android项目.压缩和缓存机制可以有效地减少网络访问的流量,在提升速度和省电方面也起
    到了较大的作用.对于新的应用程序应该更加偏向于使用HttpURLConnection,因为在以后的工作当中我们也
    会将更多的时间放在优化HttpURLConnection上面.
在Android 6.0版本中,HttpClient库被移除了,HttpURLConnection则是以后我们唯一的选择
在http早期,每个http请求都要求打开一个tcp socket连接,并且使用一次之后就断开这个tcp连接.
使用keep-alive可以改善这种状态,即在一次TCP连接中可以持续发送多份数据而不会断开连接.通过使用
    keep-alive机制,可以减少tcp连接建立次数,也意味着可以减少TIME_WAIT状态连接,以此提高性能和提高
    http服务器的吞吐率(更少的tcp连接意味着更少的系统内核调用,socket的accept()和close()调用).但是,
    keep-alive并不是免费的午餐,长时间的tcp连接容易导致系统资源无效占用.配置不当的keep-alive,有时比
    重复利用连接带来的损失还更大.所以,正确地设置keep-alive timeout时间非常重要.
SYN：同步序列编号(Synchronize Sequence Numbers).是TCP/IP建立连接时使用的握手信号.在客户机和服务
    器之间建立正常的TCP网络连接时,客户机首先发出一个SYN消息,服务器使用SYN+ACK应答表示接收到了这个
    消息,最后客户机再以ACK消息响应.这样在客户机和服务器之间才能建立起可靠的TCP连接,数据才可以在客
    户机和服务器之间传递.
ACK(Acknowledgement)即确认字符.
TCP(Transmission Control Protocol)传输控制协议是一种面向连接的、可靠的、基于字节流的传输层通信协议
GET请求的URL长度有限制.
网络层的IP协议,传输层的TCP协议
通俗而言：TCP负责发现传输的问题,一有问题就发出信号,要求重新传输,直到所有数据安全正确地传输到目的
    地.而IP是给因特网的每一台联网设备规定一个地址.
TCP例子：
    信封上写着：
    发货地：京城北拐街224号
    收货地：内乡县衙, 80号门 
    位于京城的邮差给位于内乡的县衙发消息
    第一次握手：京城发信,县衙收到了,此时县衙就会明白：京城发信能力和自己的收信能力是没问题的.　
    第二次握手：县衙发信,京城收到了,此时京城就会明白：京城的发信和收信都是好的,县衙的发信和收信也
        都是没问题的.要不然收不到县衙的回信,但是县衙还不知道自己的发信功能如何？所以需要第三次握手.
    第三次握手：京城发信,县衙收到了,此时京城已经确认,双发的收信,发信都是没问题的,这次回应的目的
        只是消除县衙对自己的发信功能和京城的收信功能的担忧而已.    
    驿站:路由器
    若消息发送失败,需要重新发送,失败的确认由发送超时确定,一次可以发送多个消息
    
[---]Retrofit2
Retrofit是Square公司开发的一款针对Android网络请求的框架
Retrofit2底层基于OkHttp实现的
同步请求网络请使用call.execute(),异步请求网络请使用call.enqueue(),如果想中断网络请求则可以使用
    call.cancel()
@Query：用来查询单个参数.
     @GET("getIpInfo.php")
     Call<IpModel> getIpMsg(@Query("ip")String ip);
@QueryMap：如果Query参数比较多,那么可以通过@QueryMap方式将所有的参数集成在一个Map统一传递.
    @GET("book/search")
    Call<BookSearchResponse> getSearchBooks(@QueryMap Map<String, String> options);
@Path：用来替换路径.
    @GET("adat/sk/{cityId}.html")
    Call<ResponseBody> getWeather(@Path("cityId") String cityId);
@Body:与@POST注解一起使用,提供查询主体内容,其中ApiInfo是一个bean类
    @POST("client/shipper/getCarType")
    Call<ResponseBody> getCarType(@Body ApiInfo apiInfo);
@Headers：用来添加头部信息
    @GET("some/endpoint")
    @Headers("Accept-Encoding: application/json")
    Call<ResponseBody> getCarType();
@Multipart：用来上传文件
@Part：单个文件上传
    @Multipart
    @POST("upload")
    Call<ResponseBody> upload(@Part("description") RequestBody description,
                              @Part MultipartBody.Part file);
@PartMap：多个文件上传         
    @Multipart
    @POST("person/photo")
    Call<User> updateUser(@PartMap Map<String, RequestBody> photos, 
                              @Part("description") RequestBody description);                     
@FormUrlEncoded：标明这是一个表单请求
@Field：标示所对应的String类型数据的键,从而组成一组键值对进行传递
    @FormUrlEncoded
    @POST("getIpInfo.php")
    Call<IpModel> getIpMsg(@Field("ip") String first);
    
[---]EventBus
EventBus好处比较明显,它能够解耦和,将业务和视图分离,代码实现比较容易.而且3.0后,我们可以通过apt预编译
    找到订阅者,避免了运行期间的反射处理解析,大大提高了效率.当然EventBus也会带来一些隐患和弊端,如果滥
    用的话会导致逻辑的分散并造成维护起来的困难.另外大量采用EventBus代码的可读性也会变差.  
APT(Annotation Processing Tool)即注解处理器,是一种处理注解的工具,确切的说它是javac的一个工具,它用
    来在编译时扫描和处理注解.注解处理器以Java代码(或者编译过的字节码)作为输入,生成.java文件作为输出.
    简单来说就是在编译期,通过注解生成.java文件. 
     
BitmapRegionDecoder长图

[---]MVP
M:实体类,MyApi
V:View接口和实现View接口的Activity,Fragment
P:就是presenter
presenter层完成二者的交互,那么肯定需要二者的实现类.大致就是从View中获取需要的参数,交给Model去执行
    业务方法,执行的过程中需要的反馈,以及结果,再让View进行做对应的显示.

[---]Java虚拟机/Dalvik虚拟机
java虚拟机运行的是Java字节码,Dalvik虚拟机运行的是Dalvik字节码;传统的Java程序经过编译,生成Java字节
    码保存在class文件中,java虚拟机通过解码class文件中的内容来运行程序.而Dalvik虚拟机运行的是Dalvik
    字节码,所有的Dalvik字节码由Java字节码转换而来,并被打包到一个DEX(Dalvik Executable)可执行文件中,
    Dalvik虚拟机通过解释Dex文件来执行这些字节码.
Java类会被编译成一个或多个.class文件,打包成jar文件,执行顺序为：.java文件 -> .class文件 -> .jar文件.
Dalvik可执行文件体积更小.SDK中有一个叫dx的工具负责将java字节码转换为Dalvik字节码,
    执行顺序为:.java文件 –>.class文件-> .dex文件.
java虚拟机与Dalvik虚拟机架构不同.java虚拟机基于栈架构.程序在运行时虚拟机需要频繁的从栈上读取或
    写入数据.这过程需要更多的指令分派与内存访问,会耗费不少CPU时间,对于像手机设备资源有限的设
    备来说,这是相当大的一笔开销.Dalvik虚拟机基于寄存器架构,数据的访问通过寄存器间直接传递,这样的
    访问方式比基于栈方式快的多.
如JVM_DVM.png所示,.jar文件里面包含多个.class文件,每个.class文件里面包含了该类的常量池、类信息、属
    性等等.当JVM加载该.jar文件的时候,会加载里面的所有的.class文件,JVM的这种加载方式很慢,对于内存
    有限的移动设备并不合适.而在.apk文件中只包含了一个.dex文件,这个.dex文件里面将所有的.class里面所
    包含的信息全部整合在一起了,这样再加载就提高了速度..class文件存在很多的冗余信息,dex工具会去除
    冗余信息,并把所有的.class文件整合到.dex文件中,减少了I/O操作,提高了类的查找速度.
 
[---]图片压缩
我们在电脑上看到的png格式或者jpg格式的图片,png(jpg)只是这张图片的容器,它们是经过相对应的压缩算法将
    原图每个像素点信息转换用另一种数据格式表示,以此达到压缩目的,减少图片文件大小.而当我们通过代码,
    将这张图片加载进内存时,会先解析图片文件本身的数据格式,然后还原为位图,也就是Bitmap对象,Bitmap
    的大小取决于像素点的数据格式以及分辨率两者了.所以,一张png或者jpg格式的图片大小,跟这张图片加载
    进内存所占用的大小完全是两回事.你不能说,我jpg图片也就10KB,那它就只占用10KB的内存空间,这是不
    对的.
在安卓中,png 或者 jpg 对于图片所占用的内存大小其实并没有影响,影响内存大小的是 
    1.图片位置：res/drawable、res/drawable-hdpi、res/drawable-xhdpi、磁盘
    2.设备：dpi=240、dpi=160
    3.分辨率
    4.像素点大小,系统默认为 ARGB_8888 作为像素点的数据格式,其他的格式如下：
        ALPHA_8 -- (1B)
        RGB_565 -- (2B)
        ARGB_4444 -- (2B)
        ARGB_8888 -- (4B)
        RGBA_F16 -- (8B)   
实验：        
    图片：分辨率 1080*452 的 jpg 格式的图片,图片文件本身大小 85.2KB
    1.图片位于res/drawable,设备dpi=240,设备1dp=1.5px,控件宽高=50dp	4393440B（4.19MB）
    2.图片位于res/drawable,设备dpi=240,设备1dp=1.5px,控件宽高=500dp	4393440B（4.19MB）
    3.图片位于res/drawable-hdpi,设备dpi=240,设备1dp=1.5px	1952640B（1.86MB）
    4.图片位于res/drawable-xhdpi,设备dpi=240,设备1dp=1.5px	1098360B（1.05MB）
    5.图片位于res/drawable-xhdpi,设备dpi=160,设备1dp=1px	488160B（476.7KB）
    6.图片位于res/drawable-hdpi,设备dpi=160,设备1dp=1px	866880（846.5KB）
    7.图片位于res/drawable,设备dpi=160,设备1dp=1px	1952640B（1.86MB）
    8.图片位于磁盘中,设备dpi=160,设备1dp=1px	1952640B（1.86MB）
    9.图片位于磁盘中,设备dpi=240,设备1dp=1.5px	1952640B（1.86MB）
先看序号 1,2 的实验,这两者的区别仅在于图片显示的控件的大小上面.做这个测试是因为,有些人会认为,图
    片占据内存空间大小与图片在界面上显示的大小会有关系,显示控件越大占用内存越多,显然,这种理解是错
    误的,图片先加载进内存后,才绘制到控件上,那么当图片要申请内存空间时,它此时还不知道要显示的控件
    大小的,怎么可能控件的大小会影响到图片占用的内存空间呢,除非提前告知,手动参与图片加载过程.
目录名称与 dpi 的对应关系如下,drawable 没带后缀对应 160 dpi：
    密度： ldpi    mdpi    hdpi    xhdpi   xxhdpi
    密度值：120     160     240     320     480    
再来看看序号2,3,4的实验,这三个的区别,仅仅在于图片在res内的不同资源目录中.当图片放在res内的不同
    目录中时,最终图片加载进内存所占据的大小会不一样,在BitmapDrawable的源码中,有一段
    (value.density * r.getDisplayMetrics().densityDpi) / srcDensityOverride代码,表示系统在加载res目
    录下的资源图片时,会根据图片存放的不同目录做一次分辨率的转换,而转换的规则是：
    新图的宽高=原图宽高 * (设备的dpi/目录对应的dpi),比如在elsetest里面的MainActivity6里面,t2图片宽
    高为1920*1200,我的金立手机的dpi为320,如果图片放在drawable-xxhdpi下,那么此时图片的在控件中显示
    的新宽为1920*(320/480)=1280,新高为1200*(320/480)=800,最后图片大小为：1280*800*4=4096000,如果图片
    放在drawable-xhdpi下,那么此时图片的在控件中显示的新宽为1920*(320/320)=1920,新高为
    1200*(320/320)=1200,最后图片大小为：1920*1200*4=9216000,如果图片放在drawable-hdpi下,那么此时
    图片的在控件中显示的新宽为1920*(320/240)=2560,新高为1200*(320/240)=1600,最后图片大小为：
    2560*1600*4=16384000,位于 res 内的不同资源目录中的图片,当加载进内存时,会先经过一次分辨率的转
    换,然后再计算大小,转换的影响因素是设备的 dpi 和不同的资源目录.若三个文件夹下都有t2图片,则取与设
    备dpi最接近的drawable的api里面的图片,我的金立手机的dpi为320,则取drawable-xhdpi里面的图片.
基于分析点 2 的理论,看下序号 5,6,7 的实验,这三个实验其实是用于跟序号  2,3,4 的实验进行对比的,
    也就是这 6 个实验我们可以得出的结论是：
    同一图片,在同一台设备中,如果图片放在 res 内的不同资源目录下,那么图片占用的内存空间是会不一样的
    同一图片,放在 res 内相同的资源目录下,但在不同 dpi 的设备中,图片占用的内存空间也是会不一样的 
序号8,9的实验,其实是想验证是不是只有当图片的来源是res内才会存在分辨率的转换,结果也确实证明了,当
    图片在磁盘中,SD卡也好,assert目录也好,网络也好（网络上的图片其实最终也是下载到磁盘）,只要不是
    在res目录内,那么图片占据内存大小的计算公式,就是按原图的分辨率*像素点大小来.在BitmapFactory的
    源码中,确实也只有decodeResource()方法内部会根据dpi进行分辨率的转换,其他decodeXXX()就没有了.       
BitmapFactory这个类提供了多个解析方法(decodeByteArray, decodeFile, decodeResource等)用于创建Bitmap
    对象,我们应该根据图片的来源选择合适的方法.比如SD卡中的图片可以使用decodeFile方法,网络上的图片
    可以使用decodeStream方法,资源文件中的图片可以使用decodeResource方法.这些方法会尝试为已经构建的
    bitmap分配内存,这时就会很容易导致OOM出现.为此每一种解析方法都提供了一个可选的
    BitmapFactory.Options参数,将这个参数的inJustDecodeBounds属性设置为true就可以让解析方法禁止为
    bitmap分配内存,返回值也不再是一个Bitmap对象,而是null.虽然Bitmap是null了,但是
    BitmapFactory.Options的outWidth、outHeight和outMimeType属性都会被赋值.
现在图片的大小已经知道了,我们就可以决定是把整张图片加载到内存中还是加载一个压缩版的图片到内存中.
    以下几个因素是我们需要考虑的：
    [1]预估一下加载整张图片所需占用的内存.
    [2]为了加载这一张图片你所愿意提供多少内存.
    [3]用于展示这张图片的控件的实际大小.
    [4]当前设备的屏幕尺寸和分辨率.
    比如,你的ImageView只有128*96像素的大小,只是为了显示一张缩略图,这时候把一张1024*768像素的图片
    完全加载到内存中显然是不值得的.
    比如我们有一张2048*1536像素的图片,将inSampleSize的值设置为4,就可以把这张图片压缩成512*384像素.
    原本加载这张图片需要占用13M的内存,压缩后就只需要占用0.75M了(假设图片是ARGB_8888类型,即每个像素
    点占用4个字节).
    
[---]进程
比如说我们希望播放音乐的Service可以运行在一个单独的进程当中,就可以这样写：
<service android:name=".PlaybackService"
         android:process=":background" />
进程名的前面都应该加上一个冒号,表示该进程是一个当前应用程序的私有进程

Paint.setTextSize传入的单位是px,TextView.setTextSize传入的单位是sp

[---]单列模式
饿汉就是类一旦加载,就把单例初始化完成,保证getInstance的时候,单例是已经存在的了
而懒汉比较懒,只有当调用getInstance的时候,才会去初始化这个单例
饿汉式天生就是线程安全的,可以直接用于多线程而不会出现问题
懒汉式本身是非线程安全的
饿汉式在类创建的同时就实例化一个静态对象出来,不管之后会不会使用这个单例,都会占据一定的内存,但是相
    应的,在第一次调用时速度也会更快,因为其资源已经初始化完成,
而懒汉式顾名思义,会延迟加载,在第一次使用该单例的时候才会实例化对象出来,第一次调用时要做初始化,如
    果要做的工作比较多,性能上会有些延迟,之后就和饿汉式一样了.

[---]String、StringBuffer和StringBuilder/CharSequence的区别
CharSequence是接口，String、StringBuffer和StringBuilder都是final类，且都实现了CharSequence这个接口。
CharSequence：接口，表示有序的字符集合
String：常量，不可变
StringBuffer：可变长度字符序列，线程安全
StringBuilder：可变长度字符序列，非线程安全
操作少量的数据,用String;
多线程操作大量数据,用StringBuffer;
单线程操作大量数据,用StringBuilder;
StringBuilder一般使用在方法内部,来完成类似"+"功能,因为是线程不安全的,所以用完以后可以丢弃.
StringBuffer主要用在全局变量中.
相同情况下使用 StringBuilder 相比使用 StringBuffer 仅能获得 10%~15% 左右的性能提升,但却要冒多线程不
    安全的风险. 而在现实的模块化编程中,负责某一模块的程序员不一定能清晰地判断该模块是否会放入多线程
    的环境中运行,因此：除非确定系统的瓶颈是在StringBuffer上,并且确定你的模块不会运行在多线程模式下,
    才可以采用StringBuilder;否则还是用StringBuffer.
[---]String
1：简单说明==与equals()区别：
(1)==：比较的是内存地址是否相同，即引用是否指向了内存中的同一个对象。指向同一个内存地址则为true；否
    则，为false。
(2)equals()：比较的是两个引用指向的值是否相同。如果指向的值是相同的，则返回true，否则，返回false。
2：从内存角度详谈String
方式一：String str1 = "hello"； 将对象放到了常量池中
方式二：String str2 = new String("hello"); 在堆中新建了一个对象
下列见图：String.png
通过方式一创建String对象，会先查看常量池中是否有这个字符串常量，如果存在，则直接将引用指向这个常量
    （即例子中：str1==str2为true）。比较疑惑的会是str3，str4。因为str3由字符串常量“he”、"ll"、“o”
    组成，编译器发现这三个常量组成的字符串常量已经存在了常量池中，即编译期间就已经确定了最终值，则也
    会将引用指向“hello”字符串常量。对于str4，因为编译器不能在编译时就确定字符串最终的值，所以会将
    字符串常量“hell”存放在常量池，再在堆中生成最终的对象【引申一下：通过“+”连接字符串，底层是通
    过new StringBuilder()的append()方法进行拼接，所以应避免在循环中使用“+”来拼接字符串，以免创建大
    量垃圾对象】。
通过方式二而创建String对象，首先会先查看常量池中是否存在这个字符串常量，如果存在，则直接在对内存中
    new出新对象；否则，会先在常量池生成这个字符串常量，再在堆中生成新对象（如图中str6）。特别注意：
    （new出对象的值为常量池中这个字符串常量的地址，也就是堆中存放的都是字符串常量中的地址）

[---]RecyclerView
控制其显示的方式,通过布局管理器LayoutManager
控制Item间的间隔(可绘制),通过ItemDecoration
控制Item增删的动画,通过ItemAnimator

[---]硬编码,就是在程序中将代码写死,不好的是如果以后这些要变动,就得重新改代码了,比较麻烦,特别是对一
    些可配置的信息,不要硬编码.
软编码,也即通过一个标记取代变量名称,而这个标记的值是可以不断变化的

[---]健壮性是指程序在运行过程中出现一般性的错误,程序会自动进行错误处理函数.
健壮性是指出错了也能继续运行的能力.
可靠性是指程序出错的概率的高低

[---]JNI
[1]简介
定义：Java Native Interface,即Java本地接口
作用：使得Java与本地其他类型语言(如C、C++)交互, 即在Java代码里调用C、C++等语言的代码或C、C++代码调
    用Java代码.
特别注意：JNI是Java调用Native语言的一种特性,JNI是属于Java的,与Android无直接关系
[2]为什么要有JNI
背景：实际使用中,Java需要与本地代码进行交互
问题：因为Java具备跨平台的特点,所以Java与本地代码交互的能力非常弱
解决方案：采用JNI特性增强Java与本地代码交互的能力
[3]实现步骤
在Java中声明Native方法(即需要调用的本地方法)
编译上述Java源文件javac(得到.class文件)
通过javah命令导出JNI的头文件(.h文件)
使用Java需要交互的本地代码实现在Java中声明的Native方法,如Java需要与C++交互,那么就用C++实现Java的
    Native方法.
编译.so库文件
通过Java命令执行Java程序,最终实现Java调用本地代码

[---]NDK
[1]简介
定义：Native Development Kit,是Android的一个工具开发包,NDK是属于Android的,与Java并无直接关系
作用：快速开发C、C++的动态库,并自动将so和应用一起打包成APK,即可通过NDK在Android中使用JNI与本地代码
    (如C、C++)交互.
应用场景：在Android的场景下使用JNI,即Android开发的功能需要本地代码(C/C++)实现
[2]使用步骤
配置AndroidNDK环境(Android Studio2.2以下需要配置NDK,Android Studio2.2以上已经内部集成NDK)
创建Android项目,并与NDK进行关联
在Android项目中声明所需要调用的Native方法
使用Android需要交互的本地代码实现在Android中声明的Native方法,比如Android需要与C++交互,那么就用C++实
    现Java的Native方法.
通过ndk-bulid命令编译产生.so库文件
编译AndroidStudio工程,从而实现Android调用本地代码

[---]Git和GitHub、GitLab
GitHub、GitLab是基于web的Git repositories(仓库).GitLab模仿GitHub,GitLab拥有GitHub拥有的一切,还拥
    有更多的安全性和灵活性.
    
[---]码云和GitHub
码云的服务器在国内,在国内访问速度比github快很多,可以免费让使自己的仓库让他人不可见,但是否安全就不知
    道了.访问速度很快,支持svn,git两种方式,免费账户同样可以建立私有项目,而github上要建立私有项目必
    须付费.
GitHub、GitLab、码云都支持Git作为代码管理工具
<--步骤1：本地上传 -->
  // a. 进入存放代码文件夹
  cd xxxx(路径)
  // b. 添加到缓存区(注add 与 . 之间有空格)
  git add .
  // c. 提交
  git commit -m "备注内容"
<--步骤2：同步到Github  -->
  git push
  // git push origin master 
JCenter = 仓库,Bintray = 送货卡车,代码库 = 货物
开源协议：文件名必须是"LICENSE"

[---]代码规范
[1]包
基础规则：小写、单词间连续无间隔、反域名法
模板：com.x.y.z  说明：com=1级包名=固定com  x=2级包名=个人/公司 y=3级包名=应用名 z=4级包名=功能模块名
示例：com.qianbao.qianbaobusiness.ui.cashier
[2]类
形式 = 驼峰形式中的 大骆驼拼写法,即名称中的每个词的首字母都大写,如 AndroidStudio
[3]变量、方法
形式 = 驼峰形式中的 小骆驼拼写法,即名称中的第1个词的首字母小写,后面每个词的首字母大写,
    如androidStudioTool

[---]动画
postInvalidate与invalidate本质上没什么不同,只不过postInvalidate可以在非UI创建线程中去通知View重绘
补间动画：优点：使用简单、方便 缺点：仅控制整体实体效果,无法控制属性
帧动画：优点：使用简单、方便 缺点：容易引起OOM
属性动画:
[1]在Java代码设置:实际开发中,建议使用Java代码实现属性动画：因为很多时候属性的起始值是无法提前确定的
    (无法使用XML设置),这就需要在Java代码里动态获取.
[2]在XML代码中设置:具备重用性,即将通用的动画写到XML里,可在各个界面中去重用它
ValueAnimator：
实现动画的原理：通过不断控制值的变化,再不断手动赋给对象的属性,从而实现动画效果
ObjectAnimator：
直接对对象的属性值进行改变操作,从而实现动画效果
ObjectAnimator与ValueAnimator类的区别：
ValueAnimator类是先改变值,然后手动赋值给对象的属性从而实现动画;是间接对对象属性进行操作;
ObjectAnimator类是先改变值,然后自动赋值给对象的属性从而实现动画;是直接对对象属性进行操作;
[Else]
详情请看elsetest1下的MainActivity.
anim文件夹下存放tween animation(补间动画);
drawable文件夹下存放frame animation(帧动画);
animator文件夹下存放property animation,即属性动画;
AnimationSet/AnimatorSet
继承关系不同,AnimationSet使用的是Animation子类,用于补间动画、AnimatorSet使用的是Animator的子类,用于
    属性动画,Animation是针对视图外观的动画实现,动画被应用时,只改变外观,但视图的触发点不会发生变
    化,还是在原来定义的位置.Animator是针对视图属性的动画实现,动画被应用时,对象属性产生变化,最终
    导致视图外观变化.

[---]JVM
为了实现跨平台,我们在操作系统和应用程序之间增加了一个抽象层：Java虚拟机
Java虚拟机及其重要,它是整个Java平台的基石,是Java语言编译代码的运行平台.你可以把Java虚拟机看做一个
    抽象的计算机,它有各种指令集和各种运行时数据区域.
[1]虚拟机并不神秘,在操作系统的角度看来,它只是一个普通进程.
[2]这个叫做虚拟机的进程比较特殊,它能够加载我们编写的class文件.如果把JVM比作一个人,那么class文件就
    是我们吃的食物.
[3]加载class文件的是一个叫做类加载器的子系统.就好比我们的嘴巴,把食物吃到肚子里.
[4]虚拟机中的执行引擎用来执行class文件中的字节码指令.就好比我们的肠胃,对吃进去的食物进行消化.
[5]虚拟机在执行过程中,要分配内存创建对象.当这些对象过时无用了,必须要自动清理这些无用的对象.清理
    对象回收内存的任务由垃圾收集器负责.就好比人吃进去的食物,在消化之后,必须把废物排出体外,腾出空
    间可以在下次饿的时候吃饭并消化食物.
Java虚拟机与java语言没有什么必然联系,它只与特定的二进制文件：Class文件有关.    
在class文件开头的四个字节,存放着class文件的魔数,这个魔数是class文件的标志,他是一个固定的值：
    0XCAFEBABE.通过这个值来判断一个文件是不是class文件格式的标准,如果开头四个字节不是0XCAFEBABE,
    那么就说明它不是class文件,不能被JVM识别.
CAFE BABE作为GBK编码解析的话刚好就是漱壕 
(1)程序第一次执行elsetest2下的Main1Acitivity时产生的对象地址日志如下：
11-06 19:10:58.963 14347-14347/com.mj.demo.elsetest2 E/MyTag: com.mj.demo.elsetest2.classes.T1@3bf0ee36
    com.mj.demo.elsetest2.classes.T1@21ee1137
    com.mj.demo.elsetest2.classes.T2@32646a4
    com.mj.demo.elsetest2.classes.T2@7aa3c0d
(2)程序没有销毁,退出Main1Acitivity后,再次进入Main1Acitivity时产生的对象地址日志如下：    
11-06 19:11:02.326 14347-14347/com.mj.demo.elsetest2 E/MyTag: com.mj.demo.elsetest2.classes.T1@2894a4a5
    com.mj.demo.elsetest2.classes.T1@e12907a
    com.mj.demo.elsetest2.classes.T2@1e48e02b
    com.mj.demo.elsetest2.classes.T2@2596bc88
(3)程序销毁后,再次执行elsetest2下的Main1Acitivity时产生的对象地址日志如下,和(1)一样的： 
11-06 19:11:09.527 15259-15259/com.mj.demo.elsetest2 E/MyTag: com.mj.demo.elsetest2.classes.T1@3bf0ee36
    com.mj.demo.elsetest2.classes.T1@21ee1137
    com.mj.demo.elsetest2.classes.T2@32646a4
    com.mj.demo.elsetest2.classes.T2@7aa3c0d

[---]Java虚拟机垃圾标记算法/垃圾收集算法
[1]垃圾标记算法
[1-1]引用计数算法
基本思想就是每个对象都有一个引用计数器,当对象在某处被引用的时候,它的引用计数器就加1,引用失效时就
    减1.当引用计数器中的值变为0,则该对象就不能被使用成了垃圾.目前主流的Java虚拟机没有选择引用计数
    算法来为垃圾标记,主要原因是引用计数算法没有解决对象之间相互循环引用的问题.
举个例子,d1和d2相互引用,除此之外这两个对象无任何其他引用,实际上这两个对象已经死亡,应该作为垃圾被
    回收,但是由于这两个对象互相引用,引用计数就不会为0,垃圾收集器就无法回收它们.    
[1-2]根搜索算法
这个算法的基本思想就是选定一些对象作为GC Roots,并组成根对象集合,然后从这些作为GC Roots的对象作为起
    始点,向下进行搜索,如果目标对象到GC Roots是连接着的,我们则称该目标对象是可达的,如果目标对象不
    可达则说明目标对象是可以被回收的对象,如图"根搜索算法.png"所示.
    从上图看以看出,Obj5、Obj6和Obj7都是不可达的对象,其中Obj5和Obj6虽然互相引用,但是因为他们到
    GC Roots是不可达的,所以它们仍旧会判定为可回收的对象,这样根搜索算法就解决了引用计数算法无法解决的
    问题：已经死亡的对象因为相互引用而不能被回收.
可以作为GC Roots的对象主要有以下几种：
    Java栈中的引用对象.
    本地方法栈中JNI引用的对象.
    方法区中运行时常量池引用的对象.
    方法区中静态属性引用的对象.
    运行中的线程
    由引导类加载器加载的对象
    GC控制的对象    
[2]垃圾收集算法
[2-1]标记-清除算法
一种常见的基础垃圾收集算法,它将垃圾收集分为两个阶段：
    标记阶段：标记出可以回收的对象.
    清除阶段：回收被标记的对象所占用的空间.
标记-清除算法主要有两个缺点,一个是标记和清除的效率都不高,另一个从图"标记-清除算法.png"就可以看出
    来,就是容易产生大量不连续的内存碎片,碎片太多可能会导致后续没有足够的连续内存分配给较大的对象,
    从而提前触发新的一次垃圾收集动作. 
标记-清除算法之所以是基础的,是因为后面讲到的垃圾收集算法都是在此算法的基础上进行改进的       
[2-2]复制算法
为了解决标记-清除算法的效率不高的问题,产生了复制算法.它把内存空间划为两个相等的区域,每次只使
    用其中一个区域.垃圾收集时,遍历当前使用的区域,把存活对象复制到另外一个区域中,最后将当前使用的
    区域的可回收的对象进行回收.复制算法的执行过程如图"复制算法.png"所示.
    这种算法每次都对整个半区进行内存回收,不需要考虑内存碎片的问题,代价就是使用内存为原来的一半.
复制算法的效率跟存活对象的数目多少有很大的关系,如果存活对象很少,复制算法的效率就会很高.由于绝大多
    数对象的生命周期很短,并且这些生命周期很短的对象都存于新生代中,所以复制算法被广泛应用于新生代中
[2-3]标记-压缩算法    
在新生代中可以使用复制算法,但是在老年代就不能选择复制算法了,因为老年代的对象存活率会较高,这样会有
    较多的复制操作,导致效率变低.标记-清除算法可以应用在老年代中,但是它效率不高,在内存回收后容易
    产生大量内存碎片.因此就出现了一种标记-压缩算法(Mark-Compact)算法,与标记-清除算法不同的是,在
    标记可回收的对象后将所有存活的对象压缩到内存的一端,使他们紧凑的排列在一起,然后对边界以外的内
    存进行回收.回收后,已用和未用的内存都各自一边,如图"标记-压缩算法.png"所示. 
标记-压缩算法解决了标记-清除算法效率低和容易产生大量内存碎片的问题,它被广泛的应用于老年代中.
[2-4]分代收集算法
在Java虚拟机中,各种对象的生命周期会有着较大的差别,大部分对象生命周期很短暂,少部分对象生命周期很
    长,有的甚至和应用程序以及Java虚拟机的运行周期一样长.因此,应该对不同生命周期的对象采取不同的收
    集策略,根据生命周期长短将它们分别放到不同的区域,并在不同的区域采用不同的收集算法,这就是分代的
    概念.       
如果所有对象都很稳定，垃圾回收器的效率降低的话，就切换到“标记-清除”方式；同样，Java虚拟机会跟踪
    “标记-清除”的效果，要是堆空间出现很多碎片，就会切换回“停止-复制”方式。这就是“自适应”技术，
    也可以叫做：“自适应的，分代的、停止-复制、标记-清除”式的垃圾回收器。 

[---]Java中引用类型分为四类：强引用、软引用、弱引用、虚引用.
强引用：强引用指的是通过new对象创建的引用,垃圾回收器即使是内存不足也不会回收强引用指向的对象.
软引用：软引用是通过SoftRefrence实现的,它的生命周期比强引用短,在内存不足,抛出OOM之前,
    垃圾回收器会回收软引用引用的对象.软引用常见的使用场景是存储一些内存敏感的缓存,当内存不足时会被
    回收.
弱引用：弱引用是通过WeakRefrence实现的,它的生命周期比软引用还短,GC只要扫描到弱引用的对象就会回收.
    弱引用常见的使用场景也是存储一些内存敏感的缓存.
虚引用：虚引用是通过FanttomRefrence实现的,它的生命周期最短,随时可能被回收.如果一个对象只被虚引用
    引用,我们无法通过虚引用来访问这个对象的任何属性和方法.它的作用仅仅是保证对象在finalize后,做某
    些事情.虚引用常见的使用场景是跟踪对象被垃圾回收的活动,当一个虚引用关联的对象被垃圾回收器回收之
    前会收到一条系统通知.
    
[---]Exception和Error的区别
Exception和Error都继承于Throwable,在Java中,只有Throwable类型的对象才能被throw或者catch,它是异常处
    理机制的基本组成类型.
Exception和Error体现了Java对不同异常情况的分类.Exception是程序正常运行中,可以预料的意外情况,可能
    并且应该被捕获,进行相应的处理.
Error是指在正常情况下,不大可能出现的情况,绝大部分Error都会使程序处于非正常、不可恢复的状态.既然是
    非正常,所以不便于也不需要捕获,常见的OutOfMemoryError就是Error的子类.
Exception又分为checked Exception和unchecked Exception.
checked Exception在代码里必须显式的进行捕获,这是编译器检查的一部分.
unchecked Exception也就是运行时异常,类似空指针异常、数组越界等,通常是可以避免的逻辑错误,具体根据
    需求来判断是否需要捕获,并不会在编译器强制要求.
    
[---]http/https
明文传输<-->加密
http状态码:
    2开头(请求成功)表示成功处理了请求的状态代码.
    3开头(请求重定向)表示要完成请求,需要进一步操作.通常,这些状态代码用来重定向.
    4开头(请求错误)这些状态代码表示请求可能出错,妨碍了服务器的处理.
    5开头(服务器错误)这些状态代码表示服务器在尝试处理请求时发生内部错误.这些错误可能是服务器本身
    的错误,而不是请求出错.
http是超文本传输协议,而https可以简单理解为安全的http协议.https通过在http协议下添加了一层ssl协议,对
    数据进行加密从而保证了安全.https的作用主要有两点：建立安全的信息传输通道,保证数据传输安全;确
    认网站的真实性.
http与https的区别主要如下：
https需要到CA申请证书,很少免费,因而需要一定的费用
http是明文传输,安全性低;而https在http的基础上通过ssl加密,安全性高
二者的默认端口不一样,http使用的默认端口是80;https使用的默认端口是443
https加密算法分为两类：对称加密和非对称加密.---(哈希算法,不是加密,但在加密过程中有作用)
请求转发/请求重定向
请求转发：当用户请求服务器的A.jsp页面时,但是A.jsp却无法处理该请求,然后转发给B.jsp,这时B.jsp页面有
    能力处理这个请求,处理请求之后将结果返回给A.jsp,最后由A.jsp页面将结果返回给用户.
请求重定向：当用户请求服务器的A.jsp页面时,但是A.jsp不知道怎么处理该请求,但知道B.jsp能够处理该请求,于
    是A.jsp告诉用户,B.jsp能处理这个请求,然后浏览器重新再根据A.jsp返回的B.jsp的地址,重新请求B.jsp.
转发在服务器端完成的；重定向是在客户端完成的 
转发的速度快；重定向速度慢 
转发的是同一次请求；重定向是两次不同请求 
转发不会执行转发后的代码；重定向会执行重定向之后的代码 
转发地址栏没有变化；重定向地址栏有变化 
转发必须是在同一台服务器下完成；重定向可以在不同的服务器下完成

[---]View基础
getX/getRawX/getTop... 图：get_getRaw.jpg,坐标.jpg
getX是以组件左上角为坐标原点.
getRawX是以屏幕左上角为坐标原点.
getY是以组件左上角为坐标原点.  
getRawY是以屏幕左上角为坐标原点(包括状态栏和标题栏).
当手滑动到整个屏幕外后,onTouchEvent会自动执行MotionEvent.ACTION_UP.
如果父控件是LinearLayout,我们就用LinearLayout.LayoutParams,如果父控件是RelativeLayout则要使用
    RelativeLayout.LayoutParams.
getTop();       //获取子View左上角距父View顶部的距离
getLeft();      //获取子View左上角距父View左侧的距离
getBottom();    //获取子View右下角距父View顶部的距离
getRight();     //获取子View右下角距父View左侧的距离    
圆一周对应的角度为360度(角度)，对应的弧度为2π弧度。
故得等价关系:360(角度) = 2π(弧度) ==> 180(角度) = π(弧度)
颜色:#AAFF0000=#AF00 前者为高精度，后者为低精度

[---]View的绘制流程    
虽然View和ViewGroup都有dispatchDraw()方法,不过由于View是没有子View的,所以一般来说dispatchDraw()这
    个方法只对ViewGroup(以及它的子类)有意义.
View的绘制流程分为3步：测量、布局、绘制,分别对应3个方法measure、layout、draw.
[1]测量阶段:measure方法会被父View调用,在measure方法中做一些优化和准备工作后会调用onMeasure方法进行
    实际的自我测量.onMeasure方法在View和ViewGroup做的事情是不一样的：
    View中的onMeasure方法会计算自己的尺寸并通过setMeasureDimension保存.
    ViewGroup中的onMeasure方法会调用所有子view的measure方法进行自我测量并保存.然后通过子View的尺寸和
    位置计算出自己的尺寸并保存.
[2]布局阶段:layout方法会被父View调用,layout方法会保存父View传进来的尺寸和位置,并调用onLayout进行实
    际的内部布局.
    onLayout在View和ViewGroup中做的事情也是不一样的：
    View:因为View是没有子View的,所以View的onLayout里面什么都不做.
    ViewGroup:ViewGroup中的onLayout方法会调用所有子View的layout方法,把尺寸和位置传给他们,让他们完
    成自我的内部布局.
[3]绘制阶段:draw方法会做一些调度工作,然后会调用onDraw方法进行View的自我绘制.draw方法的调度流程大致
    是这样的：
    绘制背景:对应drawBackground(Canvas)方法.
    绘制主体:对应onDraw(Canvas)方法.
    绘制子View:对应dispatchDraw(Canvas)方法.
    绘制滑动相关和前景:对应onDrawForeground(Canvas).
[Else]    
自定义view顺序：
    正常的：构造函数,onFinishInflate,onAttachedToWindow,onMeasure,onSizeChanged,onLayout,
        onDraw,onMeasure,onLayout,onDraw
    invisible:构造函数,onFinishInflate,onAttachedToWindow,onMeasure,onSizeChanged,onLayout,
        onMeasure,onLayout(onDraw没执行)
    gone：构造函数,onFinishInflate,onAttachedToWindow(没错,就执行这几个,从onMeasure开始包括
        onMeasure后就没执行)
MeasureSpec.UNSPECIFIED模式下,如果View没有设置背景则返回mMinWidth,如果设置了背景就返回mMinWidth
    和Drawable最小宽度两个值的最大值.        
UNSPECIFIED：未指定模式,View想多大就多大,父容器不做限制,一般用于系统内部的测量,ScrollView中的
    height设置为wrap_content.
AT_MOST：最大模式,对应于wrap_content属性(除在ScrollView布局中以外),只要尺寸不超过父控件允许的最大
    尺寸就行.
EXACTLY：精确模式,对应于match_parent属性和具体的数值,父容器测量出View所需要的大小,也就是
    specSize的值.   
ViewGroup并没有提供onMeasure()方法,而是让其子类来各自实现测量的方法,究其原因就是ViewGroup有不同的
    布局的需要很难统一. 
onLayout()方法没有去做什么,确定位置时根据不同的控件有不同的实现,所以在View和ViewGroup中均没有实现
    onLayout()方法 ,都是在子类里面实现各自的onLayout()方法,View中的onLayout()是普通函数,ViewGroup中
    的onLayout()是抽象函数,自定义ViewGroup时,必须重写该方法.        
View：measure-->onMeasure,layout-->onLayout,draw-->onDraw
ViewGroup：measureChild-->child.measure-->(View)measure-->(View)onMeasure,layout-->super.layout()-->
    (View)layout-->(View)onLayout,drawChild-->child.draw-->(View)draw-->(View)onDraw
setMeasuredDimension()方法接收的参数的单位是px.
android系统的控件以android开头的,比如android:layout_width,这些都是系统自带的属性.
自定义控件的自定义属性是以app开头的,要配合attrs使用.
LayoutInflater见elseTest1中的Main5Activity.
只要root为null,根节点宽高失效,且需要addView.root不为null,且attachToRoot为true或者不写,则自动添
    加到布局.root不为null,且attachToRoot为false,则需要addView.
当自定义ViewGroup中的onInterceptTouchEvent返回true,则该ViewGroup的onTouchEvent消费事件,如果自定义
    ViewGroup中的onInterceptTouchEvent返回false,则子节点消费事件;如HorizontalView(自定义的),一开
    始(onInterceptTouchEvent的MotionEvent.ACTION_DOWN)返回false,此时子节点可以消费事件,但是只要横
    向滑动(onInterceptTouchEvent的MotionEvent.ACTION_MOVE)来切换界面了,就返回true,不要子节点消费事
    件了.
流程：
    1	构造函数	View初始化
    2	onMeasure	测量View大小
    3	onSizeChanged	确定View大小
    4	onLayout	确定子View布局(自定义View包含子View时有用)
    5	onDraw	实际绘制内容    
onSizeChanged有四个参数，分别为宽度，高度，上一次宽度，上一次高度，我们只需关注宽度(w),高度(h)即可，
    这两个参数就是View最终的大小.    
在测量完View并使用setMeasuredDimension函数之后View的大小基本上已经确定了，但是View的大小不仅由View本
    身控制，而且受父控件的影响，所以最好在onSizeChanged回调函数中获取View的大小。    

[---]Canvas/Paint/Path/PathMeasure/Matrix/多点触控/GestureDetector
绘制的基本形状由Canvas决定，绘制出来的颜色,具体效果由Paint决定
[1]Canvas的大多数函数都是以draw开头的
画布变换:translate, scale, rotate, skew都是可以叠加的，translate将坐标系原点移动到画布正中心，scale
    的缩放中心默认为坐标原点，rotate的旋转中心也默认为坐标原点，
Canvas如果Canvas涉及到save和restore，那么在此方法内的canvas属性都是倒序的，比如：
            canvas.save();//复制了一个canvas
            canvas.translate(100, 0);
            canvas.rotate(90, mWidth / 2, mHeight / 2);//顺时针旋转
            canvas.drawRect(rect, mPaint);
            canvas.restore();
    上面的代码会先执行drawRect，然后再执行rotate,最后再执行translate，且rotate有两个构造方法，默认
        一个参数的是以(0,0)坐标为锚点，详情见elsetest2中的Main1Activity 
drawRoundRect函数：在rx为宽度的一半，ry为高度的一半时，刚好是一个椭圆，而当rx大于宽度的一半，ry大于
    高度的一半时，实际上是无法计算出圆弧的，所以drawRoundRect对大于该数值的参数进行了限制(修正)，凡
    是大于一半的参数按照一半来处理,详情见elsetest2->MyView。
drawArc(RectF oval, float startAngle, float sweepAngle, boolean useCenter,Paint paint),startAngle,开
    始角度, sweepAngle，扫过角度，useCenter，是否使用中心(true类似扇形，false填充起点和终点连线区域)
[2]Paint：
画笔模式：默认为填充模式，图：画笔模式.jpg      
线冒：默认为BUTT，图：线冒.jpg      
线段连接方式：默认为MITER，图：线段连接方式.jpg,根据数学原理我们可知，如果夹角足够小，接近于零，那么
    交点位置就会在延长线上无限远的位置。为了避免这种情况，如果连接模式为MITER(尖角)，当连接角度小于
    一定程度时会自动将连接模式转换为BEVEL(平角),角度大约是28.96°，即 MITER(尖角)模式下小于该角度的
    线段连接方式会自动转换为BEVEL(平角)模式。     
reset()，让画笔的所有设置都还原为初始状态，得到的画笔和刚创建时的状态是一样的.
注意：在使用setColor方法时，所设置的颜色必须是ARGB同时存在的，通常每个通道用两位16进制数值表示，
    如：0xFFE2A588，总共8位，其中FF表示Alpha通道。如果不设置Alpha通道，则默认Alpha通道为0，即完全透明，
    如：0xE2A588，总共6位，没有Alpha通道，如果这样设置，则什么颜色也绘制不出来。
画笔宽度，就是画笔的粗细，它通过下面的方式设置：
    // 将画笔设置为描边
    paint.setStyle(Paint.Style.STROKE);
    // 设置线条宽度
    paint.setStrokeWidth(120);
    注意：这条线的宽度是同时向两边进行扩展的，例如绘制一个圆时，将其宽度设置为120则会向外扩展60，向
        内缩进60，如图PaintWidth.jpg，因此如果绘制的内容比较靠近视图边缘，使用了比较粗的描边的情况下，
        一定要注意和边缘保持一定距离(边距>StrokeWidth/2) 以保证内容不会被剪裁掉。  
    rect.inset(50, 50);     // 向内缩小   
    只要有描边，就要考虑描边宽度占用的空间   
PathEffect
    CornerPathEffect(radius);// radius为圆角半径大小，半径越大，path越平滑,图：CornerPathEffect.jpg.    
    DashPathEffect(float intervals[], float phase);//intervals[]间隔，用于控制虚线显示长度和隐藏长度，
        它必须为偶数(且至少为 2 个)，按照[显示长度，隐藏长度，显示长度，隐藏长度]的顺序来显示,
        phase相位(和正余弦函数中的相位类似，周期为intervals长度总和)，也可以简单的理解为偏移量,图：
        DashPathEffect.jpg
    PathDashPathEffect(Path shape, float advance, float phase, PathDashPathEffect.Style style);shape:
        Path 图形,advance: 图形占据长度,phase: 相位差,style:转角样式,图：PathDashPathEffectStyle.jpg；
        参数中的shape(Path)只能是FILL模式，即便画笔是STROKE样式，shape也只会是FILL,若绘制无效，关闭
        硬件加速，setLayerType(View.LAYER_TYPE_SOFTWARE, null);
    DiscretePathEffect让Path产生随机偏移效果，DiscretePathEffect(float segmentLength, float deviation);
        segmentLength: 分段长度，deviation: 偏移距离；图：DiscretePathEffect.jpg;
    SumPathEffect(PathEffect first, PathEffect second):用于合并两种效果，它相当于两种效果都绘制一遍.
        图：SumPathEffect.jpg;
   ComposePathEffect(PathEffect outerpe, PathEffect innerpe):也是合并两种效果，只不过先应用一种效果
        后，再次叠加另一种效果，因此交换参数最终得到的效果是不同的,图：ComposePathEffect.jpg;    
getFillPath关闭硬件加速;                
[3]Path在类似addCircle这种函数中，有一个Direction参数，它是枚举(Enum)类型，里面只有两个枚举常量，如下：
    类型	 解释	         翻译
    CW	   clockwise	    顺时针
    CCW	 counter-clockwise	逆时针
path.offset(-200,-200,dst);当dst中存在内容时，dst中原有的内容会被清空，只存放复制平移后的path。
贝塞尔曲线：
    一阶曲线对应的方法是：lineTo,2个数据点,0个控制点
    二阶曲线对应的方法是：quadTo,2个数据点,1个控制点      
    三阶曲线对应的方法是：cubicTo,2个数据点,2个控制点
三阶曲线相比于二阶曲线可以制作更加复杂的形状，但是对于高阶的曲线，用低阶的曲线组合也可达到相同的效
    果，就是传说中的降阶。因此我们对贝塞尔曲线的封装方法一般最高只到三阶曲线。      
Path的交集、并集等操作，见图：Path布尔操作.jpg        
[4]PathMeasure：两个构造函数，具体使用如下：
    无参构造函数：PathMeasure()，用这个构造函数可创建一个空的PathMeasure，但是使用之前需要先调用
        setPath方法来与Path进行关联。被关联的Path必须是已经创建好的，如果关联之后Path内容进行了更改，
        则需要使用setPath方法重新关联。
    有参构造函数：PathMeasure(Path path,boolean forceClosed)，用这个构造函数是创建一个PathMeasure并关
       联一个Path，其实和创建一个空的PathMeasure后调用setPath进行关联效果是一样的，同样，被关联的Path
       也必须是已经创建好的，如果关联之后Path内容进行了更改，则需要使用setPath方法重新关联，该方法有
       两个参数，第一个参数自然就是被关联的Path了，第二个参数是用来确保Path闭合，如果设置为true，则
       不论之前Path是否闭合，都会自动闭合该Path(如果Path可以闭合的话),在这里有两点需要明确:1.不论 
       forceClosed 设置为何种状态(true 或者 false)， 都不会影响原有Path的状态，即Path与PathMeasure关
       联之后，之前的的 Path 不会有任何改变。2.forceClosed 的设置状态可能会影响测量结果，如果Path未
       闭合但在与 PathMeasure 关联的时候设置 forceClosed 为 true 时，测量结果可能会比 Path 实际长度
       稍长一点，获取到到是该 Path 闭合时的状态。
isClosed方法用于判断Path是否闭合，但是如果你在关联Path的时候设置forceClosed为true的话，这个方法的返
    回值则一定为true.       
方法：boolean getSegment (float startD, float stopD, Path dst, boolean startWithMoveTo)    
    返回值(boolean)判断截取是否成功,true表示截取成功,结果存入dst中,false截取失败,不会改变dst中内容
    startD,开始截取位置距离Path起点的长度,取值范围:0<=startD<stopD<=Path总长度
    stopD,结束截取位置距离Path起点的长度,取值范围:0<=startD<stopD<=Path总长度
    dst,截取的Path将会添加到dst中,注意:是添加，而不是替换
    startWithMoveTo,如果 startWithMoveTo为true,则被截取出来到Path片段保持原状,如果startWithMoveTo为
        false，则会将截取出来的Path片段的起始点移动到dst的最后一个点，以保证dst的连续性,如PathView4类
[5]从Matrix矩阵.jpg可以看到最后三个参数是控制透视的，这三个参数主要在3D效果中运用，通常为(0, 0, 1);           
set、pre与post方法    
    set	 设置，会覆盖掉之前的数值，导致之前的操作失效。
    pre  前乘，相当于矩阵的右乘， M' = M * S (S指为特殊矩阵)
    post 后乘，相当于矩阵的左乘，M' = S * M （S指为特殊矩阵）
Matrix:两个构造函数，具体使用如下：
    无参构造函数，Matrix ()，创建一个全新的Matrix，通过这种方式创建出来的并不是一个数值全部为空的矩
        阵，而是一个单位矩阵,如图：单位矩阵.jpg.
    有参构造函数，Matrix (Matrix src),这种方法则需要一个已经存在的矩阵作为参数。
reset函数：重置当前Matrix(将当前Matrix重置为单位矩阵)。   
setPolyToPoly函数：pointCount参数(取值范围0-4，分别是下列意思)： 
    0	相当于reset
    1	相当于translate
    2	可以进行 缩放、旋转、平移 
    3	可以进行 缩放、旋转、平移、错切 
    4	可以进行 缩放、旋转、平移、错切以及任何形变
    前面的四种情况在实际开发中很少会出现
数值计算,mapPoints mapRadius mapRect mapVectors	计算变换后的数值，也就是映射 
concat会叠加Matrix，setMatrix会重置Matrix,并且concat针对的是画布上的全部组件，而setMatrix针对的是当
    前画布，且以中心点为锚点；
[6]多点触控
getActionMasked()	与 getAction() 类似，多点触控需要使用这个方法获取事件类型。
getActionIndex()	获取该事件是哪个指针(手指)产生的。
getPointerCount()	获取在屏幕上手指的个数。
getPointerId(int pointerIndex)	获取一个指针(手指)的唯一标识符ID，在手指按下和抬起之间ID始终不变。
findPointerIndex(int pointerId)	通过PointerId获取到当前状态下PointIndex,之后通过PointIndex获取其他内容。
getX(int pointerIndex)	获取某一个指针(手指)的X坐标
getY(int pointerIndex)	获取某一个指针(手指)的Y坐标
[7]GestureDetector
若点击失效，记得添加android:clickable="true"属性 
类型	              触发次数	              摘要
onSingleTapUp	         1	        在双击的第一次抬起时触发
onSingleTapConfirmed	 0	            双击发生时不会触发
onClick	                 2	           在双击事件时触发两次
                
[---]事件分发
事件分发机制,这个知识点主要是在自定义view的时候用到；
严重BUG：记得添加属性 android:clickable="true"
默认的执行顺序(见elsetest2-->Main6Activity)：
    Main6Activity：dispatchTouchEvent->
    MyViewGroup：dispatchTouchEvent->
    MyViewGroup：onInterceptTouchEvent->
    MyView1：dispatchTouchEvent->
    MyView1：onTouchEvent->
    MyViewGroup：onTouchEvent->
    Main6Activity：onTouchEvent
先执行touch,再执行onclick(注：touch必须返回false才会执行),
view的执行顺序：dispatchTouchEvent()-->onTouch()-->onTouchEvent()-->onLongClick-->onClick,因为长按 
    onLongClickListener不需要ACTION_UP所以会在ACTION_DOWN之后就触发。
比如打印的日志：dispatchTouchEvent-->ACTION_DOWN-->onTouchEvent-->
                dispatchTouchEvent-->ACTION_MOVE-->onTouchEvent-->
                dispatchTouchEvent-->ACTION_UP-->onTouchEvent-->onClick   
当手指上抬的时候,onTouchEvent里面会执行点击操作.
viewGoup包裹view后打印的日志(默认的重写方法,或者重写onInterceptTouchEvent,并返回false):
    MyLinearLayout：0,dispatchTouchEvent-->
    MyTextView：0,dispatchTouchEvent-->MyTextView：0,ACTION_DOWN-->MyTextView：0,onTouchEvent-->
    MyLinearLayout：1,dispatchTouchEvent-->
    MyTextView：1,dispatchTouchEvent-->MyTextView：1,ACTION_UP-->MyTextView：1,onTouchEvent-->
    MyTextView：onClick               
viewGoup包裹view后打印的日志(重写onInterceptTouchEvent,并返回true): 
    MyLinearLayout：0,dispatchTouchEvent-->MyLinearLayout：0,ACTION_DOWN-->MyLinearLayout：0,onTouchEvent-->
    MyLinearLayout：1,dispatchTouchEvent-->MyLinearLayout：1,ACTION_UP-->MyLinearLayout：1,onTouchEvent-->
    MyLinearLayout：onClick
如果当前正在处理的事件被上层View拦截，会收到一个ACTION_CANCEL，后续事件不会再传递过来。    
当onTouch返回true时,只执行到onTouch方法,后面的不执行.     
ListenerInfo类(View的静态内部类),这个类是统一管理接口的

[---]SpecMode
[一]widthSpecMode:
无论父节点中是否包含ScrollView,无论直属父节点中layout_width是match_parent,还是wrap_content,或者是
    具体值,view的widthSpecMode都执行以下情况：
当view的layout_width为具体值或者match_parent时,widthSpecMode等于EXACTLY;
当view的layout_width为wrap_content时,widthSpecMode等于AT_MOST;
[二]heightSpecMode
[1]当父节点中包含ScrollView,无论直属父节点中layout_height是match_parent,还是wrap_content,或者是
    具体值,view的heightSpecMode都执行以下情况：
    (1-1)当view的layout_height为具体值时,heightSpecMode等于EXACTLY;
    (1-2)当view的layout_height为wrap_content或者match_parent时,heightSpecMode等于UNSPECIFIED;
[2]当父节点中不包含ScrollView,且直属父节点中layout_height是match_parent,或者是具体值,view的
    heightSpecMode情况如下：
    (2-1)当view的layout_height为具体值或者match_parent时,heightSpecMode等于EXACTLY;
    (2-2)当view的layout_height为wrap_content时,heightSpecMode等于AT_MOST;
[3]当父节点中不包含ScrollView,且直属父节点中layout_height是wrap_content,view的heightSpecMode情况
    如下：
    (3-1)当view的layout_height为具体值时,heightSpecMode等于EXACTLY;
    (3-2)当view的layout_height为wrap_content或者match_parent时,heightSpecMode等于AT_MOST;
[三]总结：除了(1-2)的情况,只要父节点或者view中的layout_height,layout_width是wrap_content,其
    specMode都为AT_MOST;只要view中的layout_height,layout_width是具体值,其specMode都为EXACTLY;
[四]备注：由于HorizontalScrollView不常用,就不测试了.
    
[---]屏幕适配：
今日头条屏幕适配方案：必须知道设计图总宽度
宽高限定符屏幕适配方案：各种宽高的适配
smallestWidth限定符屏幕适配方案：
    屏幕旋转：只要这个屏幕的高度大于宽度,那系统就只会认定宽度的值为最小宽度,
    反之如果屏幕的宽度大于高度,那系统就会认定屏幕的高度的值为最小宽度
    根据屏幕方向限定符生成一套资源文件,后缀加上-land或-port即可,像这样,
    values-sw400dp-land(最小宽度400dp横向),values-sw400dp-port(最小宽度400dp纵向)

[---]运行编译
直接运行：生成build文件以及其文件夹下的generated、intermediates、kotlin(没用kotlin就无此文件)、
    outputs(该文件夹下无apk文件)、tmp文件
Make project：生成build文件以及其文件夹下的generated、intermediates、kotlin(没用kotlin就无此文件)、
    outputs(该文件夹下有apk文件)、tmp文件
Clean project：生成build文件以及其文件夹下的generated、intermediates、outputs(该文件夹下无apk文件)
Rebuild project：生成build文件以及其文件夹下的generated、intermediates、kotlin(没用kotlin就无此文件)、
    outputs(该文件夹下有apk文件)、tmp文件
Make Project：编译Project下所有Module,一般是自上次编译后Project下有更新的文件
Clean Project：删除之前编译后的编译文件,并重新编译整个Project,比较花费时间
Rebuild Project：先执行Clean操作,删除之前编译的编译文件和可执行文件,然后重新编译文件

[---]Android打包过程
由android的项目经过编译和打包,形成了:
.dex 文件
resources.arsc
uncompiled resources(res)
AndroidManifest.xml
META-INF是签名文件夹
[1]aapt阶段
使用aapt来打包res资源文件,生成R.java、resources.arsc和res文件(二进制 & 非二进制如res/raw和pic保持
    原样)
[2]aidl阶段
这个阶段处理.aidl文件,生成对应的Java接口文件.
[3]Java Compiler阶段
通过Java Compiler编译R.java、Java接口文件、Java源文件,生成.class文件.
[4]dex阶段
通过dex命令,将.class文件和第三方库中的.class文件处理生成classes.dex.
[5]apkbuilder阶段
将classes.dex、resources.arsc、res文件夹(res/raw资源被原装不动地打包进APK之外,其它的资源都会被编译
    或者处理)、Other Resources(assets文件夹)、AndroidManifest.xml打包成apk文件.
    注意：
    res/raw和assets的相同点：
    1.两者目录下的文件在打包后会原封不动的保存在apk包中,不会被编译成二进制.
    res/raw和assets的不同点：
    1.res/raw中的文件会被映射到R.java文件中,访问的时候直接使用资源ID即R.id.filename;assets文件夹下
        的文件不会被映射到R.java中,访问的时候需要AssetManager类.
    2.res/raw不可以有目录结构,而assets则可以有目录结构,也就是assets目录下可以再建立文件夹
[6]Jarsigner阶段
对apk进行签名,可以进行Debug和Release 签名.
[7]zipalign阶段
release mode 下使用 aipalign进行align,即对签名后的apk进行对齐处理.
Zipalign是一个android平台上整理APK文件的工具,它对apk中未压缩的数据进行4字节对齐,对齐后就可以使用
    mmap函数读取文件,可以像读取内存一样对普通文件进行操作.如果没有4字节对齐,就必须显式的读取,这
    样比较缓慢并且会耗费额外的内存.
在Android SDK中包含一个名为"zipalign"的工具,它能够对打包后的app进行优化.其位于SDK的build-tools目录
    下, 例如: D:\Develop\Android\sdk\build-tools\23.0.2\zipalign.exe

[---]ClassLoader
我们都知道java程序写好以后是以.java（文本文件）的文件存在磁盘上,然后,我们通过(bin/javac.exe)编译命
    令把.java文件编译成.class文件（字节码文件）,并存在磁盘上.但是程序要运行,首先一定要把.class文
    件加载到JVM内存中才能使用的,我们所讲的classLoader,就是负责把磁盘上的.class文件加载到JVM内存中
当JVM需要某类时,它根据名称向ClassLoader要求这个类,然后由ClassLoader返回这个类的class对象    

[---]JavaClassLoader
类加载子系统,它的主要作用就是通过多种类加载器(ClassLoader)来查找和加载Class文件到Java虚拟机中.
    Java中的类加载器主要有两种类型,系统类加载和自定义类加载器.其中系统类加载器包括3种,分别是
    Bootstrap ClassLoader、 Extensions ClassLoader和App ClassLoader.
加载顺序
[1]Bootstrap CLassloder 
用C/C++代码实现的加载器,用于加载Java虚拟机运行时所需要的系统类,如java.lang.*、java.uti.*等这些系统
    类,它们默认在$JAVA_HOME/jre/lib目录中,也可以通过启动Java虚拟机时指定-Xbootclasspath选项,来改
    变Bootstrap ClassLoader的加载目录.Java虚拟机的启动就是通过 Bootstrap ClassLoader创建一个初始类
    来完成的.由于Bootstrap ClassLoader是使用C/C++语言实现的,所以该加载器不能被Java代码访问到.需要
    注意的是Bootstrap ClassLoader并不继承java.lang.ClassLoader.
    通过如下代码来得出Bootstrap ClassLoader所加载的目录.
    System.out.println(System.getProperty("sun.boot.class.path"));
[2]Extention ClassLoader 
用于加载 Java 的拓展类 ,拓展类的jar包一般会放在$JAVA_HOME/jre/lib/ext目录下,用来提供除了系统类之外
    的额外功能.也可以通过-Djava.ext.dirs选项添加和修改Extensions ClassLoader加载的路径.通过以下代
    码可以得到Extensions ClassLoader加载目录：
    System.out.println(System.getProperty("java.ext.dirs"));
[3]AppClassLoader  
负责加载当前应用程序Classpath目录下的所有jar和Class文件.也可以加载通过-Djava.class.path选项所指定的
    目录下的jar和Class文件.主要加载我们应用程序中的类,如Test,或者用到的第三方包,如jdbc驱动包等
[4]Custom ClassLoader
除了系统提供的类加载器,还可以自定义类加载器,自定义类加载器通过继承java.lang.ClassLoader类的方式来实
    现自己的类加载器,除了Bootstrap ClassLoader,Extensions ClassLoader和App ClassLoader也继承了
    java.lang.ClassLoader类.
[Else]
当Test.class要进行加载时,它将会启动AppClassLoader进行加载Test类,但是这个应用类加载器不会真正去加载
    他,而是会告诉Extention ClassLoader去加载,Extention ClassLoader也不会直接去加载,他也是告诉
    Bootstrap CLassloder去加载,所以这个时候Bootstrap CLassloder就去加载这个类,可在$JAVA_HOME/jre/lib
    下,它找不到com.mj.Test这个类,所以他告诉他的子类加载器,我找不到,你去加载吧,子类Extention ClassLoader
    去$JAVA_HOME/jre/lib/ext去找,也找不着,它告诉它的子类加载器 AppClassLoader,我找不到这个类,你去
    加载吧,结果AppClassLoader找到了,就加载到内存中.
System.getProperties()获得当前系统的所有属性
rt.jar：Java基础类库,也就是Java doc里面看到的所有的类的class文件.
tools.jar：是系统用来编译一个类的时候用到的,即执行javac的时候用到.
dt.jar：dt.jar是关于运行环境的类库,主要是swing包.

[---]AndroidClassLoader
[1]BootClassLoader
Android系统启动时会使用BootClassLoader来预加载常用类,与Java中的BootClassLoader不同,它并不是由
    C/C++代码实现,而是由Java实现的,BootClassLoader是ClassLoader的内部类,,并继承自ClassLoader.
[2]DexClassLoader
DexClassLoader可以加载dex文件以及包含dex的压缩文件(apk和jar文件),不管是加载哪种文件,最终都是要加
    载dex文件.
[3]PathClassLoader
Android系统使用PathClassLoader来加载系统类和应用程序的类.    
[Else]
(1)SecureClassLoader类和JDK8中的SecureClassLoader类的代码是一样的,它继承了抽象类ClassLoader.
    SecureClassLoader并不是ClassLoader的实现类,而是拓展了ClassLoader类加入了权限方面的功能,
    加强了ClassLoader的安全性.
(2)URLClassLoader类和JDK8中的URLClassLoader类的代码是一样的,它继承自SecureClassLoader,用来通过URl
    路径从jar文件和文件夹中加载类和资源.
(3)BaseDexClassLoader继承自ClassLoader,是抽象类ClassLoader的具体实现类,PathClassLoader和
    DexClassLoader都继承它.
(4)InMemoryDexClassLoader是Android8.0新增的类加载器,继承自BaseDexClassLoader,用于加载内存中的dex文件.    
在Android中,zygote是整个系统创建新进程的核心进程.zygote进程在内部会先启动Dalvik虚拟机,继而加载一
    些必要的系统资源和系统类,最后进入一种监听状态.
BootClassLoader是在Zygote进程的入口方法中创建的,PathClassLoader则是在Zygote进程创建SystemServer进程
    时创建的.

[---]一个APK中包含多个dex方法
每个单独的dex(Dalvik Executable)文件中的方法id范围为[0, 0xffff]：65536,包括安卓系统框架,三方库和
    自己写得代码中的方法.所以如果你的工程很大,包含了超过65536的方法,那就需要用multiDex技术.
缺点：会导致编译速度变慢

[---]DVM与ART的区别
DVM：Dalvik虚拟机( Dalvik Virtual Machine ),简称Dalvik VM或者DVM
ART：Android runtime
在Android5.0中,ART取代了Dalvik虚拟机(安卓在4.4中发布了ART)
DVM中的应用每次运行时,字节码都需要通过即时编译器(JIT,just in time)转换为机器码,这会使得应用的运
    行效率降低.而在ART中,系统在安装应用时会进行一次预编译(AOT,ahead of time),将字节码预先编译成
    机器码并存储在本地,这样应用每次运行时就不需要执行编译了,运行效率也大大提升. 
    
[---]scollTo/scollBy
scollTo(x,y)表示移动到一个具体的坐标点,而scollBy(dx,dy)则表示移动的增量为dx、dy.其中scollBy最终也
    是要调用scollTo的.scollTo、scollBy移动的是View的内容,如果在ViewGroup中使用,则是移动他所有的子
    View.
    
[---]Activity的构成
一个Activity包含一个window对象,这个对象是由PhoneWindow来实现的,PhoneWindow将DecorView做为整个应用
    窗口的根View,而这个DecorView又将屏幕划分为两个区域(由PhoneWindow传过来的R.layout.screen_title,
    其根节点为LinearLayout),一个是TitleView,一个是ContentView,而我们平常做应用所写的布局正是展示
    在ContentView中的.    
    
[---]Material Design
style可以重写
注意：基本上都要定义一个xmlns:app的命名空间,在Material Design的开发会经常用到它
CoordinatorLayout是一个加强版的FrameLayout.
AppBarLayout是一个垂直方向的LinearLayout(AppBarLayout继承了LinearLayout,并在构造函数中
    setOrientation(VERTICAL)).
如果你使用CoordinatorLayout来实现Toolbar滚动渐变消失动画效果,那就必须在AppBarLayout下面的那个控件中
    加入app:layout_behavior这个属性,并且下面的这个控件必须是可滚动的.当设置了layout_behavior的控件
    滑动时,就会触发设置了layout_scrollFlags的控件发生状态的改变.
layout_scrollFlags属性：scroll表示当RecyclerView向上滚动的时候Toolbar会一起向上滚动并实现隐藏,
    enterAlways表示当RecyclerView向下滚动时,Toolbar会一起向下滚动并重新显示,snap表示当Toolbar还没
    有完全隐藏或显示的时候,会根据当前滚动的距离,自动选择显示还是隐藏.
CollapsingToolbarLayout(Collapsing有折叠的意思)是一个可以作用于ToolBar基础之上的布局,可以让Toolbar的
    效果更佳丰富.不过它是不可以独立存在的,在设计时就被限定只能作为AppBarLayout的直接子布局来使用.
    android:theme属性用于指定CollapsingToolbarLayout在趋于折叠状态以及折叠之后的背景色,其实
    CollapsingToolbarLayout折叠后就是一个普通的Toolbar,背景肯定是colorPrimary了,scroll表示
    CollapsingToolbarLayout会随着内容的滚动一起滚动,exitUnitilCollapsed表示当CollapsingToolbarLayout
    随着滚动完成折叠之后就保留在界面,不再移除屏幕.app:layout_collapseMode,它用于指定当前控件在
    CollapsingToolbarLayout折叠过程中的折叠模式,其中Toolbar指定为pin表示在折叠过程中位置始终保持不
    变,ImageViwe指定成parallax,表示会在折叠的过程产生一定的错位漂移,这种模式视觉效果好.
不管是ScrollerView还是NestedScrollerView,它们的内部都只允许一个直接子布局.                                            
控件将android:fitsSystemWindows这个属性设置为true,表示该控件会出现在系统状态栏里.不仅给该控件设置此
    属性,还必须将该控件布局结构中的所有父布局都设置上这个属性才行.

[---]插件化/热修复
插件化顾名思义,更多是想把需要实现的模块或功能当做一个独立的提取出来,减少宿主的规模,当需要使用到相
    应的功能时再去加载相应的模块.
热修复则往往是从修复bug的角度出发,强调的是在不需要二次安装应用的前提下修复已知的bug.
为了方便叙述,做以下称谓约定：
宿主： 就是当前运行的APP
插件： 相对于插件化技术来说,就是要加载运行的apk类文件
补丁： 相对于热修复技术来说,就是要加载运行的.patch,.dex,*.apk等一系列包含dex修复内容的文件.

[---]热修复的产生概述
在开发中我们会遇到如下的情况：
1.刚发布的版本出现了严重的bug,这就需要去解决bug、测试并打渠道包在各个应用市场上重新发布,这会耗费大
    量的人力物力,代价会比较大.
2.已经改正了此前发布版本的bug,如果下一个版本是一个大版本,那么两个版本的间隔时间会很长,这样要等到
    下个大版本发布再修复bug,这样此前版本的bug会长期的影响用户.
3.版本升级率不高,并且需要很长时间来完成版本覆盖,此前版本的bug就会一直影响不升级版本的用户.
4.有一个小而重要的功能,需要短时间内完成版本覆盖,比如节日活动.
为了解决上面的问题,热修复框架就产生了.对于Bug的处理,开发人员不要过于依赖热修复框架,在开发的过程
    中还是要按照标准的流程做好自测、配合测试人员完成测试流程
代码修复主要有三个方案,分别是底层替换方案、类加载方案和Instant Run方案.
步骤：
下发补丁(内含修复好的class)到用户手机,即让app从服务器上下载(网络传输)
app通过“某种方式”,使补丁中的class被app调用(本地更新)    

[---]Gradle---构建工具
Ant和Maven的构建脚本是由XML来编写的.
Gant是一个基于Ant的构建工具,它在Ant的基础上用Groovy写的DSL(Domain Specifc Language,领域特定语言).
Gradle的特性:
1.轻松的可拓展性.
    如果你想要在多个构建或者项目中分享可重用代码,Gradle的插件会帮助你实现.将Gradle插件应用于你的项
    目中,它会在你的项目构建过程中提供很多帮助：为你的添加项目的依赖的第三方库、为你的项目添加有用的
    默认设置和约定(源代码位置、单元测试代码位置).其中Android Gradle插件继承Java Gradle插件.
2.采用了Groovy
     Gradle可以使用Groovy来实现构建脚本,Groovy 是基于Jvm一种动态语言,它的语法和Java非常相似并兼容
     Java,Groovy在Java的基础上增加了很多动态类型和灵活的特性,比起XML,Gradle更具有表达性和可读性.
3.强大的依赖管理
    Gradle提供了可配置的可靠的依赖管理方案.一旦依赖的库被下载并存储到本地缓存中,我们的项目就可以使
    用了.依赖管理很好的实现了在不同的平台和机器上产生相同的构建结果.
4.灵活的约定
    Gradle可以为构建你的项目提供引导和默认值,如果你使用这种约定,你的Gradle构建脚本不会有几行.
5.Gradle Wrapper      
    Gradle Wrapper是对Gradle 的包装,它的作用是简化Gradle本身的下载、安装和构建,比如它会在我们没有
    安装Gradle的情况下,去下载指定版本的Gradle并进行构建.Gradle的版本很多,所以有可能出现版本兼容的
    问题,这时就需要Gradle Wrapper去统一Gradle的版本,避免开发团队因为Gradle版本不一致而产生问题.   
6.可以和其他构建工具集成
    Gradle可以和Ant、Maven和Ivy进行集成,比如我们可以把Ant的构建脚本导入到Gradle的构建中.         
Groovy是Apache旗下的一种基于JVM的面向对象编程语言,既可以用于面向对象编程,也可以用作纯粹的脚本语言.    
当你运行Gradle时，它会检查项目中是否存在一个名为buildSrc的目录。然后Gradle会自动编译并测试这段代码，
    并将其放入构建脚本的类路径中。              
当Gradle开始执行时，会先从根目录的settings.gradle中读取参与构建的项目，即只有将子项目include才能参与
    构建，然后Gradle会读取根项目的配置，接着按字母排序，读取子项目的配置，当项目配置评测完成之后，再
    执行对应的task.doLast。 
Gradle构建中的两个基本概念是项目(project)和任务(task),每个构建至少包含一个项目，项目中包含一个或多个
    任务。在多项目构建中，一个项目可以依赖其他项目，类似的，任务可以形成一个依赖关系图来确保他们的执
    行顺序。
项目(project)：一个项目代表一个正在构建的组件(比如一个jar文件),当构建启动后，Gradle会基于build.gradle
    实例化一个org.gradle.api.Project类，并且能够通过project变量使其隐试可用,比如：
    project.apply plugin: 'com.android.application'和apply plugin: 'com.android.application'是一样的
任务(task)：任务对应org.gradle.api.Task.主要包括任务动作和任务依赖。任务动作定义了一个最小的工作单元.
    可以定义依赖于其他任务、动作序列和执行条件
minSdkVersion <= targetSdkVersion <= compileSdkVersion
minSdkVersion <= buildToolsVersion <= compileSdkVersion     
构建工具的作用：
    依赖管理；测试、打包、发布；机器能干的活，绝不自己动手。   
jar包:只包含了class文件与清单文件 ，不包含资源文件，如图片等所有res中的文件,JAR是与平台无关的文件格
    式，它允许将许多文件组合成一个压缩文件。
    Jar的优点：安全性、减少下载时间、传输平台扩展、包密封、包版本控制、可移植性。
    打jar包时，项目里的res文件是用不了的，若想用图片文件，可以将图片文件放进assets文件里面打进jar包
    再进行调用，但必须注意jar里面assets文件夹里面的文件不能和调用项目里面assets文件夹里面的文件重名.
aar包:Android库项目的二进制归档文件，包含所有资源，class以及res资源文件全部包含,将aar解压(后缀改为
    .zip，再解压文件)打开后，可以看到每个aar解压后的内容可能不完全一样，但是都会包含
    AndroidManifest.xml，classes.jar，res，R.txt。
war包：里面的东西很全，包括写的代码编译成的class文件，依赖的包，配置文件，所有的网站页面，包括html，
    jsp等等。一个war包可以理解为是一个web项目，里面是项目的所有东西。    
apply plugin后有什么插件,gradle才能搜索到这个插件，可以通过gradle来打包成jar包、aar包、war包，创建task
    任务，也可以在gradle中搜索到这个任务，比如在根build.gradle中加入下面的代码(建议新建任务后，都要对
    gradle进行刷新)：
    task makeJavaDir(){
        def paths=[]
    }
    那么在Gradle->GLB->GLB->Tasks->other下就可以看到这个任务(其他目录下没该任务)，自定义的任务都会在
    other下面,详情可见根build.gradle和elsetest2->build.gradle里的makeElseJavaDir方法，当makeElseWebDir
    任务依赖于makeElseJavaDir任务，则会出现下面的执行顺序出现：
    :elsetest2:makeElseJavaDir
    :elsetest2:makeElseWebDir
    详情可见根build.gradle和elsetest2->build.gradle里的makeElseWebDir方法
例子：当执行gradle->Tasks->build->build这个任务，出现的UP-TO-DATE文本表示最新的，在上次构建之后，这
    个任务的输入输出没有改变，所以会跳过，当java文件改变了，他就会重新执行
构建生命周期：初始化、配置、执行    
doFirst和doLast里面的代码都是动作代码 ，也就是执行阶段会执行的代码，其余代码属于配置阶段的代码，
    dependsOn只能在配置阶段执行，因为配置阶段就要决定任务的依赖关系和执行顺序           
仓库是用来存放jar包的地方，常用仓库：1.mavenLocal;2.mavenCentral;3.jcenter
    后两个是公共仓库，放在公网上的，我们可以上传jar包和依赖里面的jar包，第一个是本地仓库;一般优先使
    用私服仓库(比如公司自己的仓库)，然后使用本地仓库，最后使用远程仓库，执行顺序如下：
    maven{
        url '私服地址'
    }
    mavenLocal()
    mavenCentral()
通过dependencies可以查看依赖关系，一般情况下，版本冲突不需要我们自己处理，gradle默认帮我们选择了最新
    的版本
    
[---]算法
时间复杂度：评估执行程序所需的时间.可以估算出程序对处理器的使用程度.
空间复杂度：评估执行程序所需的存储空间.可以估算出程序对计算机内存的使用程度.
设计算法时,一般是要先考虑系统环境,然后权衡时间复杂度和空间复杂度,选取一个平衡点.不过,时间复杂度
    要比空间复杂度更容易产生问题,因此算法研究的主要也是时间复杂度,不特别说明的情况下,复杂度就是指
    时间复杂度.
推导大O阶,我们可以按照如下的规则来进行推导,得到的结果就是大O表示法：
1.用常数1来取代运行时间中所有加法常数.
2.修改后的运行次数函数中,只保留最高阶项
3.如果最高阶项存在且不是1,则去除与这个项相乘的常数.    
将O(1)、O(n)、O(logn)、O(n²)分别可以称为常数阶、线性阶、对数阶和平方阶.
下面算法的时间复杂度：
for(int i=0;i<n;i++){   
    for(int j=i;j<n;i++){
       //复杂度为O(1)的算法
       ... 
    }
}
执行次数为：n+(n-1)+(n-2)+(n-3)+……+1=n²/2+n/2
根据此前讲过的推导大O阶的规则的第二条：只保留最高阶,因此保留n²/2.根据第三条去掉和这个项的常数,则
    去掉1/2,最终这段代码的时间复杂度为O(n²).
除了常数阶、线性阶、平方阶、对数阶,还有如下时间复杂度：
f(n)=nlogn时,时间复杂度为O(nlogn),可以称为nlogn阶.
f(n)=n³时,时间复杂度为O(n³),可以称为立方阶.
f(n)=2ⁿ时,时间复杂度为O(2ⁿ),可以称为指数阶.
f(n)=n!时,时间复杂度为O(n!),可以称为阶乘阶.
f(n)=(√n时,时间复杂度为O(√n),可以称为平方根阶.
常用的时间复杂度按照耗费的时间从小到大依次是：
O(1)<O(logn)<O(n)<O(nlogn)<O(n²)<O(n³)<O(2ⁿ)<O(n!)
排序算法稳定性的简单形式化定义为：如果Ai = Aj,排序前Ai在Aj之前,排序后Ai还在Aj之前,则称这种排序算
    法是稳定的.通俗地讲就是保证排序前后两个相等的数的相对顺序不变.
对于不稳定的排序算法,只要举出一个实例,即可说明它的不稳定性;而对于稳定的排序算法,必须对算法进行分
    析从而得到稳定的特性.需要注意的是,排序算法是否为稳定的是由具体算法决定的,不稳定的算法在某种条
    件下可以变为稳定的算法,而稳定的算法在某种条件下也可以变为不稳定的算法.
例如,对于冒泡排序,原本是稳定的排序算法,如果将记录交换的条件改成A[i] >= A[i + 1],则两个相等的记
    录就会交换位置,从而变成不稳定的排序算法.
排序算法稳定性就是一组元素,其中有重复的元素,比如2113,我们把前面的1记为1a,后面的1记为1b,那 么原始数据
    为21a1b3,如果排序后重复元素的相对位置不变,那么,这个排序是稳定的.如上例子,排序完应该是1a1b23才是
    稳定的,而不是1b1a23.    
希尔排序和插入排序很相似,只是把1换成了增量h.
[---]冒泡排序
时间复杂度：由于内外循环都发生N次迭代，所以时间复杂度为O(n^2)。并且这个界是精确的。思考最坏的情况，
    输入一个逆序的数组，则比较次数为：(N-1)+(N-2)+(N-3)+..+2+1 = n*(n-1)/2 = O(n^2)
空间复杂度：只使用了一个临时变量，所以为O(1)；
是否稳定：稳定排序
[---]选择排序
时间复杂度：O(n^2)
空间复杂度：只使用了一个临时变量，所以为O(1)；
稳定性：不稳定排序。如序列3A，5，3B，1。第一次交换结果为1，5，3B，3A，原序列第一个3排在了第二个3后面。
[---]插入排序
和打扑克牌时，从牌桌上逐一拿起扑克牌，在手上排序相同。
时间复杂度：O(n^2)
空间复杂度：只使用了一个临时变量，所以为O(1)；
稳定性：稳定

[---]设计模式
设计六大原则:
1.单一职责原则:低耦合.
2.开放封闭原则:对于拓展是开放的,对于修改是封闭的.
3.里氏替换原则
4.依赖倒置原则:在Java中,抽象就是指接口或者抽象类,两者都是不能直接被实例化的;细节就是实现类,实现
    接口或者继承抽象类而产生的就是细节,也就是可以加上一个关键字new产生的对象.高层模块就是调用端,
    低层模块就是具体实现类.依赖倒置原则在Java中的表现就是：模块间通过抽象发生,实现类之间不发生直接
    依赖关系,其依赖关系是通过接口或者抽象类产生的.如果类与类直接依赖细节,那么就会直接耦合,那么当
    修改时,就会同时修改依赖者代码,这样限制了可扩展性.
5.迪米特原则:尽量减少对象之间的交互,每一个类都应当尽量降低其成员变量和成员函数的访问权限.
6.接口隔离原则
[I]创建型设计模式
[1]单例模式
定义：保证一个类仅有一个实例,并提供一个访问它的全局访问点.
[2]建造者模式
定义：将一个复杂对象的构建与它的表示分离,使得同样的构建过程可以创建不同的表示.
1.创建产品类;2.创建Builder接口规范产品的组建并创建实现类实现该接口;3.创建Director指挥者类来统一组装
    过程;4.客户端调用指挥者类.
优点：使用建造者模式可以使客户端不必知道产品内部组成的细节. 
    具体的建造者类之间是相互独立的,容易扩展.   
[3]简单工厂模式
定义：又叫做静态工厂方法模式,是由一个工厂对象决定创建出哪一种产品类的实例.
1.创建抽象产品类;2.创建具体产品类;3.创建工厂类;4.客户端调用工厂类;
优点：根据参数获得对应的类实例,避免了直接实例化类,降低了耦合性.
[4]工厂方法模式
定义：一个用于创建对象的接口,让子类决定实例化哪个类.工厂方法使一个类的实例化延迟到其子类.
1.创建抽象产品;2.创建具体产品;3.创建抽象工厂;4.具体工厂;5.客户端调用;
简单工厂模式我们都知道,在工厂类中包含了必要的逻辑判断,根据不同的条件来动态实例化相关的类,对客户端
    来说,去除了与具体产品的依赖,与此同时也会带来一个问题：如果我们去增加产品,比如我们要生产苹果电脑,
    那我们就需要在工厂类中在添加一个Case分支条件,这违背了开放封闭原则;而工厂方法模式就没有违背这个开
    放封闭原则,如果我们需要生产苹果电脑,并不需要去修改工厂类,直接创建产品就好了.
[5]抽象工厂模式
定义：为创建一组相关或者相互依赖的对象提供一个接口,而无需指定它们的具体类.
1.创建抽象产品;2.创建具体产品;3.创建抽象工厂;4.具体工厂;5.客户端调用;(就是和工厂方法一样,不过有两层)
系统中有多于一个的产品线,而每次只使用其中某一产品线.
优点:具体类的创建实例过程与客户端分离,客户端通过工厂的抽象接口操纵实例,客户端并不知道具体的实现是谁.
[6]原型模式
定义：用原型实例指定创建对象的种类,并通过拷贝这些原型创建新的对象.
原型模式的核心是clone方法,通过该方法进行拷贝.
浅拷贝：不会拷贝对象中的内部数组和引用对象,导致它们仍旧指向原来对象的内部元素地址.
深拷贝：所有都会拷贝的
使用场景：如果类的初始化需要耗费较多的资源,那么可以通过原型拷贝避免这些消耗.
    通过new产生一个对象需要非常繁琐的数据准备或访问权限,则可以使用原型模式.
优点：原型模式是在内存中二进制流的拷贝,要比new一个对象的性能要好,特别是需要产生大量对象时.
[II]结构型模式
[1]代理模式
定义：代理模式也叫委托模式,是结构型设计模式的一种.在现实生活中我们用到类似代理模式的场景有很多,
    比如代购、代理上网、打官司,明星和经纪人等.
代理模式的类型：安全代理：用来控制真实对象访问时的权限(其他的看不懂).
[2]装饰模式
定义：动态地给一个对象添加一些额外的职责,就增加功能来说,装饰模式比生成子类更为灵活.
通过创建一个包装对象,也就是装饰来包裹真实的对象.
通过组合而非继承的方式,动态的来扩展一个对象的功能,在运行时选择不同的装饰器具体实现类,从而实现不同
    的行为.
[3]外观模式
定义：将子系统的逻辑和交互隐藏起来,为用户提供一个高层次的接口,使得系统更加易用,同时也隐藏了具体的
    实现,这样即使具体的子系统发生了变化,用户也不会感知到.
当我们开发Android的时候,无论是做SDK还是封装API,我们大多都会用到外观模式,它通过一个外观类使得整个
    系统的结构只有一个统一的高层接口,这样能降低用户的使用成本.    
[4]享元模式    
定义：享元模式是结构型设计模式的一种,是池技术的重要实现方式,它可以减少应用程序创建的对象,降低程序
    内存的占用,提高程序的性能.
在enjoyElement中,name作为内部状态是不变的,并且作为Map的key值是可以共享的.而showGoodsPrice方法中需
    要传入的version值则是外部状态,他的值是变化的.
使用场景:系统中存在大量的相似对象.
[III]行为型模式
[1]观察者模式
定义:观察者模式(又被称为发布-订阅(Publish/Subscribe)模式,它定义了一种一对多的依赖关系,让多个观察者
    对象同时监听某一个观察者.这个观察者在状态变化时,会通知所有观察者对象,使他们能够自动更新自己.
使用场景：
    跨系统的消息交换场景,如消息队列、事件总线的处理机制.        
[2]模版方法模式
定义：在软件开发中,有时会遇到类似的情况,某个方法的实现需要多个步骤,其中有些步骤是固定的,而有些步
    骤并不固定,存在可变性.为了提高代码的复用性和系统的灵活性,可以使用模板方法模式来应对这类情况.
优点：模板方法模式通过把不变的行为搬移到超类,去除了子类中的重复代码.且易扩展.
使用场景：
    各子类中公共的行为应被提取出来并集中到一个公共父类中以避免代码重复.
    面对重要复杂的算法,可以把核心算法设计为模版方法,周边相关细节功能则有各个子类实现.
    需要通过子类来决定父类算法中某个步骤是否执行,实现子类对父类的反向控制.
[3]策略模式
定义：解决在出现很多选择而导致代码臃肿的情况.
使用场景:
    对客户隐藏具体策略(算法)的实现细节,彼此完全独立.
    针对同一类型问题的多种处理方式.
[4]中介者模式
定义：用一个中介者对象来封装一系列的对象交互.中介者使得各对象不需要显式地相互引用,从而使其松散耦
    合,而且可以独立地改变它们之间的交互.
[5]状态模式
定义：当一个对象的内在状态改变时允许改变其行为,这个对象看起来像是改变了其类.
优点：每个状态都是一个子类,方便增加和修改状态;状态被放置到类的内部,外部调用不需要知道类的内部如何
    实现状态和行为的变换.
缺点：完全使用状态模式,可能会导致子类会过多.
使用场景：
    代码中包含大量对象状态与条件有关的语句.
    对象的行为依赖着状态,并且行为随着状态的改变而改变.

[---]矢量图
SVG：即Scalable Vector Graphics 可缩放矢量图形,简称矢量图
http://inloop.github.io/svg2android/:该网站可以在线将SVG图片转换为Android Vector Drawable
http://editor.method.ac/:SVG的编辑器来进行SVG图像的编写
Vector图像刚发布的时候,是只支持Android 5.0+的,对于Android pre-L的系统来说,并不能使用,所以,可以
    说那时候的Vector并没有什么卵用.不过自从AppCompat 23.2之后,Vector可以使用于Android 2.1以上的所
    有系统,只需要引用com.android.support:appcompat-v7:23.2.0以上的版本就可以了,同时,确保你使用的是
    AppCompatActivity而不是普通的Activity.
可以说Vector就是Android中的SVG实现,因为Android中的Vector并不是支持全部的SVG语法,也没有必要,因为完整
    的SVG语法是非常复杂的,但已经支持的SVG语法已经够用了,特别是Path语法,几乎是Android中Vector的标配    
android:viewportHeight\android:viewportWidth:定义图像被划分的比例大小,例如vd_check.xml中的24,即把
    100dp大小的图像划分成24份,后面Path标签中的坐标,就使用这里划分后的坐标系统,这样做有一个非常好
    的作用,就是将图像大小与图像分离,后面可以随意修改图像大小,而不需要修改PathData中的坐标
支持的指令：
    M = moveto(M X,Y) ：将画笔移动到指定的坐标位置,一般代表着一段path的开始.
    L = lineto(L X,Y) ：画直线到指定的坐标位置
    H = horizontal lineto(H X)：画水平线到指定的X坐标位置
    V = vertical lineto(V Y)：画垂直线到指定的Y坐标位置
    C = curveto(C X1,Y1,X2,Y2,ENDX,ENDY)：三次贝赛曲线
    S = smooth curveto(S X2,Y2,ENDX,ENDY)
    Q = quadratic Belzier curve(Q X,Y,ENDX,ENDY)：二次贝赛曲线
    T = smooth quadratic Belzier curveto(T ENDX,ENDY)：映射
    A = elliptical Arc(A RX,RY,XROTATION,FLAG1,FLAG2,X,Y)：弧线
    Z = closepath()：关闭路径
使用原则:
    坐标轴为以(0,0)为中心,X轴水平向右,Y轴水平向下
    所有指令大小写均可.大写绝对定位,参照全局坐标系；小写相对定位,参照父容器坐标系
    指令和数据间的空格可以省略
    同一指令出现多次可以只用一个
如果使用了Appcomat后,系统会自动把ImageView转换为AppcomatImageView.
setBackgroundResource也是可以设置Vector的API,如果要在xml写app:srcCompat="@drawable/vd_check",需要
    配置vectorDrawables.useSupportLibrary = true
AnimatedVector华丽登场,把vector和动画文件黏合在一起.使用起来很简单,先通过drawable属性指定vector,
    然后通过target标签把动画和对象绑定在一起,注意：group标签才有android:rotation属性,path没有.
trimPath一共有三个相关的属性：trimPathStart,trimPathEnd,trimPathOffset,都是float类型的数值,数值范
    围从0到1.分别表示path从哪里开始,到哪里结束,距离起点多远. 
路径变形：需要注意的是,两条path的绘制指令需要在数量和结构上都相同.比如第一条path的指令(省略了坐标)是
    "M,L,L,C,Z",那第二条path的指令也应该是"M,L,L,C,Z"这种形式.    
animated-selector允许定义有多个vector,根据不同状态使用不同的vector,并且通过animated-vector定义不同
    vector之前切换的动画.
所以我们接下来的步骤是：
    定义两个vector：勾和圆
    定义两个animated-vector:勾转化为圆,圆转化为勾
    定义animated-selector把上述的文件组合起来.
    第一个item指定的是state_checked="false"时显示的样子,第二个item指定的是state_checked="true"时显
        示的样子.第一个transition指定的是从check切换到circle时所做的动画,第二个transition指定的是
        从circle切换到check时所做的动画.fromid和toId表示变换前后两个item的id.
rXxx方法的坐标使用的是相对位置(基于当前点的位移),比如path.moveTo(100,100);path.lineTo(100,200);第二
    个点的坐标就是(100,200);path.moveTo(100,100);path.rLineTo(100,200);第二个点的坐标就是(200,300),
    下一个点的位置是在当前点的基础上加上偏移量得到的，即(100+100, 100+200)这个位置;
    
[---]token
Token是在客户端频繁向服务端请求数据，服务端频繁的去数据库查询用户名和密码并进行对比，判断用户名和密
    码正确与否，并作出相应提示，在这样的背景下，Token便应运而生.Token的目的是为了验证用户登录情况以
    及减轻服务器的压力，减少频繁的查询数据库，使服务器更加健壮。
首先,从字面上理解,token 是令牌的意思.在开发中,token 则是由服务器通过一些特定的算法生成的字符串,是客
    户端和服务端交互的令牌.token 生成之后会发送给客户端,客户端收到 token 之后,它每次与服务器交互都需
    要携带 token,否则服务器就会返回错误码.在实战中,返回的错误码都是由后端编程人员决定的,而我们 
    Android 开发要做的就是根据服务器返回的错误码告诉用户这里出了什么错误.
一般情况下,客户端都需要向服务端获取数据和上传数据,那么服务器就需要知道具体的每一个请求是由哪一个用户
    发起的,服务端才好操作相对应用户的数据.在初始阶段是通过每次请求都带上用户名和密码来唯一确认一个请
    求的,但是这样会使服务器的压力增大,会增加服务器的查询操作.因此token应运而生,在每次登录成功之后,都
    保存服务端生成的唯一token到本地,就可以唯一确认一个请求了,我们就可以顺畅地访问服务端了.如图：
    token.jpg
Token的应用：
    1.当用户首次登录成功之后,服务器端就会生成一个token值,这个值,会在服务器保存token值(保存在数据库
        中),再将这个token值返回给客户端.
    2.客户端拿到token值之后,使用sp进行保存.
    3.以后客户端再次发送网络请求(一般不是登录请求)的时候,就会将这个token值附带到参数中发送给服务器.
    4.服务器接收到客户端的请求之后,会取出token值与保存在本地(数据库)中的token值做对比!
    5.如果两个token值相同,说明用户登录成功过!当前用户处于登录状态!
    6.如果没有这个token值,没有登录成功.
    7.如果token值不同,说明原来的登录信息已经失效,让用户重新登录.  
                   
[---]反射
Java反射机制是指在运行状态中
对于任意一个类，都能知道这个类的所有属性和方法,对于任何一个对象，都能够调用它的任何一个方法和属性,这
    样动态获取以及动态调用对象方法的功能就叫做反射。
1.获取Class
获取类的三种方法:
    Class c = Class.forName("java.lang.String");  //这里一定要用完整的包名
    Class c1=String.class;
    String str = new String();
    Class c2=str.getClass();
    这里获取的c,c1以及c2都是相等的。一般在反射中会用第一种写法。    
2.获取类的属性（成员变量）
    Field[] fields = c.getDeclaredFields();       
3.获取类的方法
    Method[] ms = c.getDeclaredMethods();            
备注：常用方法如图：常用方法.jpg
setAccessible(true)的使用表示可以访问非public的变量，理论上来说，这样做是不安全的，不符合面向对象的
    思想，但是，你也会发现，反射给我们提供了一种在运行时改变对象的方法.
 
[---]IO流/File
[1]IO流用来处理设备之间的数据传输，进行文件的上传和下载
分类：字节流，OutputStream写，InputStream读;
      字符流，Reader读，Writer写；
      上面的4个流对象都是抽象类,我们不能直接使用,我们需要使用子类.
[2]File
new File("/tmp/one/two/three").mkdirs();执行后，会建立tmp/one/two/three四级目录
new File("/tmp/one/two/three").mkdir();则不会建立任何目录，因为找不到/tmp/one/two目录，结果返回false
                 
[---]内部类
一个Java文件里面不能有一个以上的public类(除了内部类).
内部类不会单独编译成一个class文件.
非静态内部类可以访问外围类的方法和字段,包括私有，就像自己拥有一样,其隐式地保存了一个引用(this)，指向
    创建它的外围类对象.
静态内部类又叫做嵌套类.嵌套类没有这个this引用,这使得它类似于一个static方法.
只有在匿名内部类的引用调用自己方法时，该方法才执行，见elsetest2-->testInnerClass()方法；
在匿名内部类末尾的分号，是用来标记表达式的结束.
在匿名内部类中不可能有命名构造器(因为它根本没有名字),但通过实例初始化，就能够达到为匿名内部类创建一
    个构造器的效果.局部内部类和抽象类可以有命名构造器.见elsetest2-->testInnerClass()方法；
在匿名内部类中调用外部参数，该参数的引用必须是final类型。  
外围类允许继承多个非接口类型(类或抽象类),也就是说外围类可以组合多个内部类，见Java编程思想P204-10.8

[八]多态
向上转型不能调用新方法和父类的私有方法，必须强转.
静态方法是与类相关联，而并非与单个对象相关联.所以向上转型调用的静态方法是父类的静态方法.

[十一/十七]持有对象/容器深入研究
见：elseTest2-->colloectionTest()方法,elseTest2-->seniorContainer()方法
Collection每个槽中保存一个对象，Map每个槽中保存了两个对象(键值对).
List、Set、Queue都是接口，并且继承自Collection，Map是接口，但没有继承Collection.
toString()@后面跟随该对象的散列码的无符号十六进制(这个散列码由hashCode()方法产生).
容器提供的toString()和Object的toString()方法不同.Map的toString()在AbstractMap抽象类中，Collection的
    toString()在AbstractCollection抽象类中.
HashSet(HashMap)提供了最快的查找技术，没有按照任何明显的顺序来保存其元素.TreeSet(TreeMap),按照比较
    结果的升序保存对象(键),LinkedHashSet(LinkedHashMap)按照插入顺序保存对象(键).
TreeSet实现了SortedSet.TreeMap实现了SortedMap.
LinkedList和PriorityQueue都实现了Queue.
    PriorityQueue(优先级队列),最小的值拥有最高的优先级.
    LinkedList(双向队列),可以在任何一端添加或移除元素.
LinkedHashMap<Integer, String> map1 = new LinkedHashMap<>(16,0.75f,accessOrder);当accessOrder(访问顺
    序)为true时，表示元素访问后，会被移到队列后端
当一个类被用作HashMap的键，若想要查找到该键，则该类需要重写hashCode()和equals()方法.基本数据类型不用
    重写hashCode()和equals()方法.(还有HashSet、LinkedHashSet、LinkedHashMap这些散列的数据结构).
ArrayList底层由数组支持；LinkedList是由双向链表实现的。
HashMap和LinkedHashMap：
    容量：表中的桶位数
    初始容量：表在创建时所拥有的桶位数
    尺寸：表中当前存储的项数
    负载因子：尺寸/容量.默认是0.75.当负载情况达到该负载因子的水平时，容器将自动增加其容量，实现方式
        是使容量大致加倍,并重将现有对象分布到新的桶位集中(这被称为再散列).
    如果你知道将要存储多少项，那么创建一个具有恰当大小的初始容量将可以避免自动再散列的开销.
程序运行时发生异常，因为在容器取得迭代器之后，又有东西被放入到了该容器中。当程序的不同部分修改同一个
    容器时，就可能导致容器的状态不一致，如下：
    List<String> list = new ArrayList<>();
    Iterator<String> iterator = list.iterator();
    list.add("An object");
    try {
        iterator.next();
    } catch (ConcurrentModificationException e) {
        System.out.println(e);
    }
    应该在添加完所有的元素之后，再获取迭代器.    
Java 1.0/1.1的容器
    vector：可看做ArrayList.
    Enumeration:可看做Iterator.
    Hashtable:可看做HashMap.            
    Stack：可看做LinkedList.
    
[十二]通过异常处理错误
见：elseTest2-->exceptionTest()方法
改进错误的恢复机制是提供代码健壮性最强有力的方式.
对异常来说,最重要的部分就是类名，自定义异常可以不需要构造器.
大多数情况下都只是查看一下抛出的异常类型，其他的就不管了，所以对异常所添加的其他功能也许根本用不上.
异常的基本概念是用名称代表发生的问题，并且异常的名称应该可以望文知意.
e.printStackTrace()和System.err比System.out要快，因为System.out可能被重定向.前两个在控制台输出的文本
    是红色的，System.out输出的则是白色的。
RuntimeException(运行时异常)和其子类，可以不用throws，try，catch;
只要有throws，就必须有try，catch，但可以没有throw,常用于抽象基类和接口,见Writer类的write()方法;
Throwable可以分为两种类型(继承自Throwable)：Error用来表示编译时和系统错误(除特殊情况外，一般不用你关
    心);Exception是可以被抛出的基本类型，在Java类库、用户方法以及运行时都可能抛出的异常。所以Java程
    序员关心的通常是Exception.
finally总会执行(哪怕提前return)，并且会跳到更高一层的异常处理之前执行.
finalize()不确定是否会被调用，即使被调用，也不知道什么时候调用.

[十三]字符串
见：elseTest2-->stringTest()方法
String对象具有只读特性，指向它的任何引用都不可能改变它的值.
如果想要打印对象的内存地址，应该用Object.toString()方法，而不是重写的toString()方法.
如果内容没有发生改变，String的方法只是返回指向原对象的引用而已.
正则表达式："abc+"表示匹配ab，后面跟随1个或多个c，"(abc)+"表示匹配1个或多个完整的abc字符串.
在必要时添加空格，来确保一个域至少达到某个长度，默认右对齐，不过可以通过使用“-”标志来改变对其方向，
    如：System.out.format("%9s", "str");System.out.format("%-9s", "str");

[十四]类型信息
见：elseTest2-->typeInfoTest()方法
运行时类型信息使得你可以在程序运行时发现和使用类型信息.
如何让我们在运行时识别对象和类的信息呢？主要有两种方式：
    1：RTTI，它假定我们在编译时已经知道了所有的类型；
    2.反射，它允许我们在运行时发现和使用类的信息；
先调用this,再调用toString();
反射会自动执行静态初始化.如：Class.forName("com.m j.demo.elsetest2.myClass.testClass.ClassDisplay");
使用newInstance()来创建的类，必须带有默认构造器或者无参构造器;
instanceof和isInstance()一样，指“你是这个类或者这个类的派生类吗”，==和equals()一样，指确切的类型.
RTTI(Run-Time Type Information，运行时类型信息，比如向上转型，动态绑定的)和反射之间真正的区别只在于，
    前者在编译时打开和检查.class文件，后者在.class编译时是不可获取的，所以在运行时打开和检查.class文
    件.
getDeclaredMethods()：获得某个类的所有声明的字段，即包括public、private和proteced（不包括继承的方法）
getMethods()：获得某个类的所有的公共（public）的字段（包括继承的类或接口的方法）
getDeclaredFields()：获得某个类的所有声明的字段，即包括public、private和proteced，但是不包括父类的申
    明字段。
getFields()：获得某个类的所有的公共（public）的字段，包括父类中的字段。
新模式见：elseTest2-->listTest()方法

[十五]泛型
见：elseTest2-->genParTest()方法
基本类型无法作为类型参数.但Java具备自动打包和自动拆包的功能，可以很方便地在基本类型和其相应的包装类
    型之间进行转换.
擦除，任何具体的类型信息都被擦除了，唯一知道的就是你在使用一个对象,也就是Object.
Plate<Fruit> p=new Plate<>(new Apple());编译出错，装苹果的盘子不是一个装水果的盘子.
Plate<? extends Fruit> p=new Plate<>(new Apple());编译通过.图：上界通配符.jpg
Plate<? super Apple> p1=new Plate<>(new Fruit());编译通过.图：下界通配符.jpg
<? extends T>是指“上界通配符（Upper Bounds Wildcards）”不能往里存任何元素，只能往外取
<? super T>是指“下界通配符（Lower Bounds Wildcards）”不影响往里存，但往外取只能放在Object对象里
<?>无界通配符.
若容器类在处理对象时，没添加泛型，那么就将它们看为没有任何具体类型(Object),如下;
    List<Car> list = new ArrayList();list.add(Car对象);
    List list = new ArrayList();list.add(Object对象);

[十六]数组
见：elseTest2-->arrayTest()方法
强调的是性能而不是灵活性.优选容器而不是数组.
基本类型数组(可以自动包装)；对象数组；
System.arraycopy()不会执行自动包装和自动拆包，两个数组必须具有相同的确切类型;
使用内置的排序算法，就可以对任意的基本类型数组排序；也可以对任意的对象数组进行排序，只要改对象实现了
    Comparable接口或者具有相关联的Comparator.

[十八]Java I/O系统   
见：elseTest1-->MyExampleUnitTest-->testFile()、elseTest2-->MyElseTest1-->testSerializable()方法
File：既能代表一个特定文件的名称，又能代表一个目录下的一组文件的名称(调用list()方法).
"适配器"类:InputStreamReader可以把InputStream转换为Reader.OutputStreamWriter可以把OutputStream转换为
    Writer.
InputStream和OutputStream,两个是为字节流设计的,主要用来处理字节或二进制对象,
Reader和Writer.两个是为字符流(一个字符占两个字节)设计的,主要用来处理字符或字符串.
如果是音频文件、图片、歌曲,就用字节流好点,如果是关系到中文(文本),用字符流好点.
所有文件的储存是都是字节(byte)的储存,在磁盘上保留的并不是文件的字符而是先把字符编码成字节,再储存
    这些字节到磁盘.在读取文件(特别是文本文件)时,也是一个字节一个字节地读取以形成字节序列.
字节流可用于任何类型的对象,包括二进制对象,而字符流只能处理字符或者字符串.
字节流是最基本的,主要用在处理二进制数据,它是按字节来处理的,但实际中很多的数据是文本,又提出了字符流的
    概念,它是按虚拟机的encode来处理,也就是要进行字符集的转化 这两个之间通过InputStreamReader,
    OutputStreamWriter来关联,实际上是通过byte[]和String来关联,在实际开发中出现的汉字问题实际上都是在
    字符流和字节流之间转化不统一而造成的. 
InputStreamReader和OutputStreamWriter是从字节流到字符流的桥接器    
FileWriter是被修饰者 
BufferedWriter是修饰者
一般用法为 
    BufferedWriter bw = new BufferedWriter(new FileWriter( "filename")); 
    上面这个加了一个缓冲,缓冲写满后再将数据写入硬盘 
    这样做极大的提高了性能 
    如果单独使用FileWriter也可以 
    你每写一个数据,硬盘就有一个写动作,性能极差
FileReader不能一行行读,BufferedReader可以一行行地读
BufferedReader可以一行行地读效率高,因为减少了IO的次数
有一种PrintWriter构造器还有一个选项，就是“自动执行清空”选项，如果构造器设置为true，则在每个
    Println()，printf()或format()执行之后，便会自动清空.否则，可能看不到输出.如下：
    PrintWriter printWriter = new PrintWriter(System.out, true);
    printWriter.println("hhhh");
ByteBuffer是将数据移进移出通道的唯一方式.rewind()把position设置到缓冲器的开始位置.
二进制序列化保持类型保真度，这对于在应用程序的不同调用之间保留对象的状态很有用。
XML序列化仅序列化公共属性和字段，且不保持类型保真度。
Preferences API与对象序列化相比，前者与对象持久性更亲密，因为它可以自动存储和读取信息.
恢复Serializable对象不会调用构造器，恢复Externalizable会调用无参构造器.
transient(瞬时)关键字,关闭序列化，不会保存或恢复数据，由于Externalizable对象在默认情况下不保存它们的
    任何字段，所以transient关键字只能和Serializable对象一起使用.
序列化会将private数据保存下来，如果关心安全问题，那么应该将其标记成transient. 

[十九]枚举类型
见：elseTest2-->MyElseTest-->getEnum()方法
所有的enum都继承自java.lang.Enum类.
enum实例必须写在enum类中的第一行
enum实例定义时的次序决定了其在EnumSet和EnumMap中的顺序.
enum的values是一个数组.

[二十]注解
注解(也被称为元数据)为我们在代码中添加信息提供了一种形式化的方法，使我们可以在稍后某个时刻非常方便地
    使用这些数据.
注解也会被编译成class文件.
用@interface表明一个注解，注解只有成员变量，没有方法。注解的成员变量以“无形参的方法”形式来声明，方
    法名定义了该成员变量的名字，其返回值定义了该成员变量的类型。
元注解
1.@Retention
用来标记自定义注解的有效范围，他的取值有以下三种：
    RetentionPolicy.SOURCE: 只在源代码中保留 一般都是用来增加代码的理解性或者帮助代码检查之类的，比
        如我们的Override;
    RetentionPolicy.CLASS: 默认的选择，能把注解保留到编译后的字节码class文件中，运行时是无法得到；
    RetentionPolicy.RUNTIME:注解不仅能保留到class字节码文件中，还能在运行通过反射获取到，这也是我们
        最常用的。
    要明确生命周期长度SOURCE<CLASS<RUNTIME，所以前者能作用的地方后者一定也能作用。一般如果需要在运行
    时去动态获取注解信息，那只能用RUNTIME注解；如果要在编译时进行一些预处理操作，比如生成一些辅助代
    码(如ButterKnife)，就用CLASS注解；如果只是做一些检查性的操作，比如@Override和@SuppressWarnings，
    则可选用SOURCE注解。
2.@Target
@Target指定Annotation用于修饰哪些程序元素。
@Target也包含一个名为"value"的成员变量，该value成员变量类型为ElementType[ ]，ElementType为枚举类型，
    值有如下几个：
    ElementType.TYPE：修饰类、接口或枚举类型
    ElementType.FIELD：修饰成员变量
    ElementType.METHOD：修饰方法
    ElementType.PARAMETER：修饰参数
    ElementType.CONSTRUCTOR：修饰构造器
    ElementType.LOCAL_VARIABLE：修饰局部变量
    ElementType.ANNOTATION_TYPE：修饰注解
    ElementType.PACKAGE：修饰包
    举例：属性上不能使用ElementType.METHOD，必须使用ElementType.FIELD，否则编译失败
    也可以以逗号分隔的形式指定多个值，如果想要将注解应用于所有的ElementType，那么可以省去该元注解.
3.@Document：说明该注解将被包含在javadoc中
4.@Inherited：说明子类可以继承父类中的该注解
如果我们将注解里的RetentionPolicy.RUNTIME改为RetentionPolicy.CLASS或者RetentionPolicy.SOURCE，那么
    isAnnotationPresent()就会失效，可能导致编译不通过或者变量为null，方法不执行(invoke)等情况.                   
备注：有时候会发生无缘无故的错误，只需要Clean Project一下就行了，应该是缓存的问题。
"动态"就是使用注解和反射最大的意义，我们可以动态的访问对象.
标准注解：
1.@Override:表示当前的方法定义将覆盖超类中的方法.
2.@Deprecated
3.SuppressWarning:关闭不当的编译器警告信息
注解元素：
    1.所有基本类型
    2.String
    3.Class
    4.enum
    5.Annotation
    6.以上类型的数组
没有元素的注解称为标记注解。
单元测试 @Test 方法中不能有参数.

[二十一]并发
见：elseTest2-->MyElseTest1-->threadTest()方法
更快的执行：速度提高是以多核处理器的形式而不是更快的芯片的形式出现的.
将runnable对象转变为工作任务的传统方式是把它提交给一个Thread构造器.
Runnable是执行工作的独立任务，但是它不返回任何值。如果你希望任务在完成时能够返回一个值，那么可以实现
    Callable接口而不是Runnable接口.
优先级较低的线程仅仅是执行的频率较低.    
后台线程，是指在程序运行时在后台提供一种通用服务的线程。当所有的非后台线程结束时，程序也就终止，同时
    会杀死进程中的所有的后台线程，也就是说，只要有任何非后台线程还在运行，程序就不会终止。
在线程启动前调用setDaemon方法，才能将该线程设置为后台线程.    
见：threadTest()，由于线程的本质特性，使得你不能捕获从线程中套逃逸的异常，一旦异常逃出任务的run()方
    法，它就会向外传播到控制台，除非你采用特殊的步骤捕获这种错误的异常.
如果某个任务处于一个对标记为synchronized的方法的调用中，那么在这个线程从该方法返回之前，其他所有要调
    用类中任何标记为synchronized方法的线程都会被阻塞.   
被设计用来响应interrupt()的类必须建立一种策略，在所有需要清理的对象创建操作的后面 ，都必须紧跟着
    try-finally语句，使得无论run()循环如何退出，清理都会发生.
wait().notify()以及notifyAll()都是Object的一部分，而不是Thread的一部分.
实际上，只能在同步控制方法或同步控制块里调用wait().notify()和notifyAll().否则会在运行时得到
    IllegalMonitorStateException异常.
当notifyAll()因某个特定锁而被调用时，只有等待这个锁的任务才会被唤醒.        
notifyAll()全部唤醒，notify只唤醒一个，且被唤醒的任务是notifyAll()中全部唤醒的其中一个(随机的).   
少数量：synchronized快于Atomic快于Lock
多数量：Atomic快于Lock快于synchronized
由于synchronized可读性强，所以只有在性能调优时才替换为Lock；Atomic对象只有在非常简单的情况下才有用，
    这些情况通常包括你只有一个要被修改的Atomic对象，并且这个对象独立于其他所有对象，只有在性能方面的
    需求明确指示时，再替换为Atomic.
加锁的同时也有可能产生死锁.

[---]线程
sleep()和yield()不释放同步锁,wait()释放同步锁
sleep(milliseconds)可以用时间指定来使他自动醒过来,如果时间不到你只能调用interreput()来强行打断;
wait()可以用notify()直接唤起.
sleep是Thread类的静态方法,Thread.sleep(1000);
wait是Object的方法,obj.wait();
这两者的施加者是有本质区别的.
sleep()是让某个线程暂停运行一段时间,其控制范围是由当前线程决定,也就是说,在线程里面决定.好比如说,
    我要做的事情是 "点火->烧水->煮面",而当我点完火之后我不立即烧水,我要休息一段时间再烧.对于运行的主
    动权是由我的流程来控制.
而wait(),首先,这是由某个确定的对象来调用的,将这个对象理解成一个传话的人,当这个人在某个线程里面说"暂
    停!", 也是 thisOBJ.wait(),这里的暂停是阻塞,还是"点火->烧水->煮饭",thisOBJ就好比一个监督我的人站
    在我旁边,本来该线程应该执行1后执行2,再执行3,而在2处被那个对象喊暂停,那么我就会一直等在这里而不执
    行3,但整个流程并没有结束,我一直想去煮饭,但还没被允许, 直到那个对象在某个地方说"通知暂停的线程启
    动!",也就是thisOBJ.notify()的时候,那么我就可以煮饭了, 这个被暂停的线程就会从暂停处继续执行.
sleep(100)在100毫秒后肯定会运行,但wait在100毫秒后还有等待os调用分配资源,
    所以wait(100)的停止运行时间是不确定的,但至少是100毫秒.
一般推荐实现Runnable接口的方式,首先,Thread类定义了多种方法可以被派生类使用重写,但是只有run()方法是必
    须被重写的,实现这个线程的主要功能,这也是实现Runnable接口需要的方法.因此如果没有必要重写Thread类
    的其他方法,那么在这种情况下最好用实现Runnable接口的方式. 比如在Thread的子类中可以直接写
    sleep(1000),而在Runnable的实现类必须写Thread.sleep(1000).
Thread.yield()方法作用是：暂停当前正在执行的线程对象,并执行其他线程.    
[1]. 新建状态(New)：新创建了一个线程对象.
[2]. 就绪状态(Runnable)：线程对象创建后,其他线程调用了该对象的start()方法.该状态的线程位于可运
     行线程池中,变得可运行,等待获取CPU的使用权.
[3]. 运行状态(Running)：就绪状态的线程获取了CPU,执行程序代码.
[4]. 阻塞状态(Blocked)：阻塞状态是线程因为某种原因放弃CPU使用权,暂时停止运行.直到线程进入就绪
     状态,才有机会转到运行状态.阻塞的情况分三种：
        等待阻塞：运行的线程执行wait()方法,JVM会把该线程放入等待池中.
        同步阻塞：运行的线程在获取对象的同步锁时,若该同步锁被别的线程占用,则JVM会把该线程放入锁池中.
        其他阻塞：运行的线程执行sleep()或join()方法,或者发出了I/O请求时,JVM会把该线程置为阻塞状态.
            当sleep()状态超时、join()等待线程终止或者超时、或者I/O处理完毕时,线程重新转入就绪状态.
[5]. 死亡状态(Dead)：线程执行完了或者因异常退出了run()方法,该线程结束生命周期.   
[Else]
线程安全(Thread-safe)的集合对象：Vector、HashTable、StringBuffer；
非线程安全的集合对象：ArrayList、LinkedList、HashMap、HashSet、TreeMap、TreeSet、StringBulider;

[---]线程池
如果并发的线程数量很多,并且每个线程都是执行一个时间很短的任务就结束了,这样频繁创建线程就会大大降低
    系统的效率,因为频繁创建线程和销毁线程需要时间.那么有没有一种办法使得线程可以复用,就是执行完一
    个任务,并不被销毁,而是可以继续执行其他的任务？在Java中可以通过线程池来达到这样的效果.
corePoolSize：核心池的大小.当线程池中的线程数目达到corePoolSize后,就会把到达的任务放到缓存队列当中.
maximumPoolSize：线程池最大线程数.
keepAliveTime：表示线程没有任务执行时最多保持多久时间会终止.默认情况下,只有当线程池中的线程数大于
    corePoolSize时,keepAliveTime才会起作用,直到线程池中的线程数不大于corePoolSize,即当线程池中的
    线程数大于corePoolSize时,如果一个线程空闲的时间达到keepAliveTime,则会终止,直到线程池中的线程
    数不超过corePoolSize.但是如果调用了allowCoreThreadTimeOut(boolean)方法,在线程池中的线程数不大
    于corePoolSize时,keepAliveTime参数也会起作用,直到线程池中的线程数为0；
unit：参数keepAliveTime的时间单位.
workQueue：一个阻塞队列.
    workQueue的类型为BlockingQueue<Runnable>,通常可以取下面三种类型：
    1)ArrayBlockingQueue：基于数组的先进先出队列,此队列创建时必须指定大小;
    2)LinkedBlockingQueue：基于链表的先进先出队列,如果创建时没有指定此队列大小,则默认为
        Integer.MAX_VALUE;
    3)synchronousQueue：这个队列比较特殊,它不会保存提交的任务,而是直接新建一个线程来执行新来的任务.
threadFactory：线程工厂,主要用来创建线程.
handler：表示当拒绝处理任务时的策略.
corePoolSize在很多地方被翻译成核心池大小,其实我的理解这个就是线程池的大小.举个简单的例子：
    假如有一个工厂,工厂里面有10个工人,每个工人同时只能做一件任务.因此只要当10个工人中有工人是空闲
    的,来了任务就分配给空闲的工人做;当10个工人都有任务在做时,如果还来了任务,就把任务进行排队等
    待;如果说新任务数目增长的速度远远大于工人做任务的速度,那么此时工厂主管可能会想补救措施,比如重
    新招4个临时工人进来;然后就将任务也分配给这4个临时工人做;如果说着14个工人做任务的速度还是不够,
    此时工厂主管可能就要考虑不再接收新的任务或者抛弃前面的一些任务了.当这14个工人当中有人空闲时,而
    新任务增长的速度又比较缓慢,工厂主管可能就考虑辞掉4个临时工了,只保持原来的10个工人,毕竟请额外
    的工人是要花钱的.这个例子中的corePoolSize就是10,而maximumPoolSize就是14(10+4).也就是说
    corePoolSize就是线程池大小,maximumPoolSize在我看来是线程池的一种补救措施,即任务量突然过大时的一
    种补救措施.
largestPoolSize只是一个用来起记录作用的变量,用来记录线程池中曾经有过的最大线程数目,跟线程池的容量
    没有任何关系.

[---]volatile
volatile作用：使变量在多个线程可见。
一般提到volatile,就不得不提到内存模型相关的概念.我们都知道,在程序运行中,每条指令都是由CPU执
    行的,而指令的执行过程中,势必涉及到数据的读写.程序运行中的数据都存放在主存中,这样会有一
    个问题,由于CPU的执行速度是要远高于主存的读写速度,所以直接从主存中读写数据会降低CPU的效率.为了
    解决这个问题,就有了高速缓存的概念,在每个CPU中都有高速缓存,它会事先从主存中读取数据,在CPU运算
    之后在合适的时候刷新到主存中.
原子性：即一个操作或者多个操作要么全部执行并且执行的过程不会被任何因素打断,要么就都不执行.
    比如从账户A向账户B转1000元,那么必然包括2个操作：从账户A减去1000元,往账户B加上1000元.
    即使是在多个线程一起执行的时候,一个操作一旦开始,就不会被其它线程干扰.
可见性：可见性是指当多个线程访问同一个变量时,一个线程修改了这个变量的值,其他线程能够立即看得到修改
    的值.举个简单的例子,看下面这段代码：
    //线程1执行的代码
    int i=0;
    i=10;
    //线程2执行的代码
    j=i;
假若执行线程1的是CPU1,执行线程2的是CPU2.由上面的分析可知,当线程1执行i=10这句时,会先把i的初始值加
    载到CPU1的高速缓存中,然后赋值为10,那么在CPU1的高速缓存当中i的值变为10了,却没有立即写入到主存
    当中.此时线程2执行j=i,它会先去主存读取i的值并加载到CPU2的缓存当中,注意此时内存当中i的值还是0,
    那么就会使得j的值为0,而不是10.这就是可见性问题,线程1对变量i修改了之后,线程2没有立即看到线程1
    修改的值.
    当一个共享变量被volatile修饰时,它会保证修改的值会立即被更新到主存,所以对其他线程是可见的,当有
    其他线程需要读取时,它会去内存中读取新值.而普通的共享变量不能保证可见性,因为普通共享变量被修改
    之后,什么时候被写入主存是不确定的,当其他线程去读取时,此时内存中可能还是原来的旧值,因此无法保
    证可见性.
有序性：即程序执行的顺序按照代码的先后顺序执行
    重排序时是会考虑指令之间的数据依赖性,如果一个指令2必须用到指令1的结果,那么处理器会保证指令1会
    在指令2之前执行.指令重排序不会影响单个线程的执行,但是会影响到线程并发执行的正确性.
总结：也就是说,要想并发程序正确地执行,必须要保证原子性、可见性以及有序性.只要有一个没有被保证,就
    有可能会导致程序运行不正确.volatile无法保证原子性,但可保证可见性,有序性.
   
[---]ThreadLocal：线程局部变量,线程本地变量,或叫线程本地存储
ThreadLocal在当前线程操作数据只对当前线程有效，其set()和get()方法都不是synchronized的，因为
    ThreadLocal保证不会出现竞争条件.
应用场景：数据库连接、Session管理

[---]断点
分类：
    行断点：就经常用的那种断点
    方法断点: 一般用来检查方法的「输入参数」与「返回值」
    变量断点: 在程序运行过程中，如果该变量的值发生改变，程序会自动停下来，并定位到变量值改变的地方
    条件断点: 比如for循环设置：i == 2
    日志断点: 右键断点，去掉「Suspend」的勾选，勾选「Evaluate and log」在此输入想输出的内容，比如输
        入："输出此时i的值为："+ i
    临时断点: 触发一次后就自动删除的断点，去掉「Suspend」的勾选，勾选「Remove once hit」的选项.
    异常断点：一旦程序奔溃，直接定位到异常所在的确切位置.
当程序执行到断点所在的代码时，会暂停应用程序的运行，线程被挂起，然后可以通过调试器进行跟踪。
大毛毛虫：每次都需要重新运行程序.
小毛毛虫：直接调试正在运行的Android进程.

[---]AR
OpenGL着色语言（OpenGL Shading Language）是用来在OpenGL中着色编程的语言,GLSL其使用C语言作为基础高阶
    着色语言.
openGL是用C语言实现的，而我们作为安卓开发者，严格来讲，我们使用的是es，也就是openGL es，原因无非就像
    数据库一样，安卓上使用的数据库永远不可能是MySQL之类的，因为终端讲究轻量。
System.arraycopy方法的使用:
    src:源数组； 
    srcPos:源数组要复制的起始位置； 
    dest:目的数组； 
    destPos:目的数组放置的起始位置； 
    length:复制的长度。 
    注意：src and dest都必须是同类型或者可以进行转换类型的数组．
GLSL的变量命名方式与C语言类似,变量名不能以gl_作为前缀，这个是GLSL保留的前缀，用于GLSL的内部变量.

[---]Weex
-g是全局的意思
node.js是weex编译、打包用的基础工具，javascript和node.js关系，类似于java与jvm
npm是nodejs的包管理工具，相当于android中的gradle,但是npm在国内访问速度较慢，建议大家安装cnpm，是淘宝
    的一个npm国内镜像
安装cnpm：npm install -g cnpm --registry=https://registry.npm.taobao.org
备注：以下的npm关键字皆可换为cnpm.    
1.weex开发环境的搭建
    安装依赖node.js，npm也随之安装了
    (将npm5降级到npm4，命令如下：npm i npm@4 -g)
    通过命令npm install  -g  weex-toolkit安装weex-toolkit,安装后即可使用weex指令.
    在一个文件夹终端通过weex init awesome-app(新建文件夹)命令创建项目，或者通过weex create awesome-app
        命令直接创建一个空的模板项目
    进入awesome-app，执行npm install命令,安装依赖.
    进入到awesome-app终端，执行npm run dev命令(好像可以不执行)
    重新打开一个awesome-app的终端，执行npm run serve或者npm start命令，即可打开一个网页.
    进入到awesome-app，通过weex platform add android命令来添加android平台的项目
    进入到awesome-app，通过weex run android命令在模拟器或真实设备上启动应用（注意：在此之前必须将
        AndroidSDK配置到环境变量中，并且重新打开cmd，再次执行该命令,如果出现
        Error: Error: Command failed: call gradlew.bat  assembleRelease，请修改gradle版本，尽量和AS
        的gradle版本对应）
    遇到Cannot set the value of read-only property 'outputFile' for...这个BUG，搜索applicationVariants
        这个关键字，将其的方法块改为：                
        android.applicationVariants.all { variant ->
                variant.outputs.all {
                    outputFileName = "weex-app.apk"
                }
            }        
    出现Failed to download Chromium r609904这个BUG，用cnpm            
    其他各种BUG，导入项目慢慢调试吧.        
2.weex通用样式
    (1)适配和缩略：
        1.Weex对于长度值目前只支持像素值，不支持相对单位(em,rem);适配以750px为标准.
        2.设定边框，border目前不支持类似这样的border:1px solid #ff0000;的组合写法
        3.设定背景色，background目前不支持类似这样background:red的写法，需要修改为具体的
            background-color:red.
    (2)定位：
        1.weex支持position定位，relative|absolute|fixed|sticky，默认值为relative
        2.weex目前不支持z-index设置元素层级关系，但靠后的元素层级更高，因此，对于层级高的元素，可将
            其排在后面。            
        3.如果定位元素超过容器边界，在Android下，超出部分将不可显示，因为Android端元素overflow默认值
            为hidden。
    (3)其他:
        1.weex支持线性渐变linear-gradient，不支持radial-gradient径向渐变          
        2.weex中box-shadow仅仅支持ios(支持了).
        3.目前<image>组件无法定义一个或几个角的border-radius，只对ios有效，对Android无效(支持了)
        4.weex中，flexbox是默认并且唯一的布局模型，每个元素都默认拥有display:flex属性.
3.weex内建组件
    (1).组件：
        <a>组件：
            1.组件中无法添加文本，需要在其中加上text组件才能添加文本(支持了).
            2.支持除了自己外的所有Weex组件作为子组件
            3.支持所有通用样式.
            4.请不要为该组件添加click事件.
        <web>组件：
            1.<web>组件用于在页面中潜入一张网页;
            2.不支持任何子组件.
            3.pagestart,pagefinish,error分别表示组件开始加载，完成加载，加载错误时执行.
        <webview>模块:
            1.一系列<web>组件的操作接口.可以通过调用this.$refs.el来获取元素的引用.
            2.goBack(webElement),加载历史记录里的前一个资源地址.            
            3.goForward(webElement),加载历史记录里的下一个资源地址.
            4.reload(webElement),刷新当前页面.            
               
3.其他：
    修改代码后别点保存(ctrl+s)，直接将鼠标焦点点到除集成环境的其他界面
    通过BootCDN搜索vue，关联vue.min.js(压缩版本).
    npm install -g @vue/cli;npm run serve;vue ui;
    store(vuex)中央操作.
    alert()后面的语句需要点击确定后才能执行
    在当前目录下执行对应的vue文件，使用vue serve demo1.vue命令
    v-model 指令，它能轻松实现表单输入和应用状态之间的双向绑定
    Vue.js 为 v-bind 和 v-on 这两个最常用的指令，提供了特定简写,如下:
        <!-- 完整语法 -->                       <!-- 完整语法 -->
        <a v-bind:href="url">...</a>            <a v-on:click="doSomething">...</a>
        <!-- 缩写 -->                           <!-- 缩写 -->
        <a :href="url">...</a>                  <a @click="doSomething">...</a>
    优先级：render函数选项 > template选项 > outer HTML.  
    我们可以将同一函数定义为一个方法而不是一个计算属性(computed)。两种方式的最终结果确实是完全相同的。
        然而，不同的是计算属性是基于它们的依赖进行缓存的。只在相关依赖发生改变时它们才会重新求值。这
        就意味着只要 message 还没有发生改变，多次访问 reversedMessage 计算属性会立即返回之前的计算结
        果，而不必再次执行函数。          
    如果需要非常频繁地切换，则使用 v-show (display: none;)较好；如果在运行时条件很少改变，则使用 
        v-if(直接从DOM树删掉) 较好
    items: ['a', 'b', 'c']    vm.items[1] = 'x'和 vm.items.length = 2都不是响应性的        
    todos.splice(index,1),第一个参数，规定添加/删除项目的位置，使用负数可从数组结尾处规定位置，第二个
        参数表示要删除的项目数量，如果设置为 0，则不会删除项目。
    有些 HTML 元素，诸如 <ul>、<ol>、<table> 和 <select>，对于哪些元素可以出现在其内部是有严格限制的。
        而有些元素，诸如 <li>、<tr> 和 <option>，只能出现在其它某些特定的元素内部。     
    .fade-enter-to 和 .fade-leave 默认状态 opacity: 1     
    Vue 的模板实际是编译成了 render 函数
    模板指的就是挂载点内部的内容
    {{}}内的内容叫做插值表达式
    scoped限制样式作用范围，表示该样式只对当前组件有效
    根据Vue2.0官方文档关于父子组件通讯的原则，父组件通过prop传递数据给子组件，子组件触发事件给父组件。
        但父组件想在子组件上监听自己的click的话，需要加上native修饰符。所以如果在想要在router-link上
        添加事件的话需要@click.native这样写。$emit。
    要想产生动画，transition必须是组件根节点
    css3中属性前缀：
        1、-moz-代表firefox浏览器私有属性
        2、-ms-代表ie浏览器私有属性
        3、-webkit-代表safari、chrome私有属性
        4、-o-代表Opera
        这些是为了兼容老版本的写法
    1em = 16px       
    相对定位的元素框会偏移某个距离。元素仍然保持其未定位前的形状，它原本所占的空间仍保留。
    绝对定位的元素框从文档流完全删除.“相对于”最近的已定位祖先元素，如果不存在已定位的祖先元素，那么
        “相对于”最初的包含块.
    XML 被设计为传输和存储数据，其焦点是数据的内容,HTML 被设计用来显示数据，其焦点是数据的外观。HTML
        旨在显示信息，而 XML 旨在传输信息。
    XML 没有预定义的标签。在 HTML 中使用的标签（以及 HTML 的结构）是预定义的。HTML 文档只使用在 HTML
        标准中定义过的标签（比如 <p> 、<h1> 等等）。
    在 Weex 中，Flexbox 是默认且唯一的布局模型，所以你不需要手动为元素添加 display: flex; 属性。
    根元素上加上属性 bubble=true 才能开启冒泡。
    首先在JS端执行 addEventListener 方法注册监听事件。然后在android端调用 fireGlobalEventCallback 这
        个方法.
                             
[---]CPU类型
armeabi-v7a: 第7代及以上的 ARM 处理器。2011年15月以后的生产的大部分Android设备都使用它.
arm64-v8a: 第8代、64位ARM处理器，很少设备，三星 Galaxy S6是其中之一。
armeabi: 第5代、第6代的ARM处理器，早期的手机用的比较多。
x86: 平板、模拟器用得比较多。
x86_64: 64位的平板。

为了减小 apk 体积，只保留 armeabi 和 armeabi-v7a 两个文件夹，并保证这两个文件夹中 .so 数量一致
对只提供 armeabi 版本的第三方 .so，原样复制一份到 armeabi-v7a 文件夹 

[---]文件签名
给我们自己开发的app签名，就代表着我自己的版权，以后要进行升级，也必须要使用相同的签名才行。签名就代
    表着自己的身份（即keystore），多个app可以使用同一个签名。

[---]Handler
主要作用：1.在工作线程中发送消息;2.在UI线程中获取、处理消息。
获取 Message 对象的两种方式:
1.Message message = new Message();
2.Message obtain = Message.obtain();
先翻译一下 obtain 的方法的注释文档。
Return a new Message instance from the global pool.
Allows us to avoid allocating new objects in many cases.
从全局池返回一个新的消息实例。允许我们在许多情况下避免分配新对象。
看到这里大家心里应该有底了，就是在复用之前用过的 Message 对象，这里实际上是用到了一种享元设计模式，
    这种设计模式最大的特点就是复用对象，避免重复创建导致的内存浪费。
    
[---]JetPack    
DataBinding 数据绑定
    能够省去我们一直以来的 findViewById() 步骤，大量减少 Activity 内的代码，数据能够单向或双向绑定到 
    layout 文件中，有助于防止内存泄漏，而且能自动进行空检测以避免空指针异常
Lifecycle 的实现机制是观察者模式：    
    1. 构建一个 Lifecycle 对象（通过一个实现了 LifecycleOwner 接口的对象的 getLifecycle()方法返回），
       这个对象就是一个被观察者，具有生命周期感知能力    
    2. 构建一个 LifecycleObserver 对象，它对指定的 Lifecycle 对象进行监听    
    3. 通过将 Lifecycle 对象的 addObserver(…) 方法，将Lifecycle对象和LifecycleObserver对象进行绑定
LiveData 的作用是在使得数据能具有生命周期感知能力，在 Activity 等变为活跃状态的时候，自动回调观察者
    中的回调方法。也就是说对数据的变化进行实时监听。
ViewModel 的作用则是，当因系统配置发生改变导致 Activity 重建的时候（比如旋转屏幕），能对 LiveData 
    进行正确的保存和恢复。
Navigation 导航
    Navigation graph（导航图）:
    这是一个包含所有位置导航相关信息的XML资源文件。这里包括应用程序当中的所有单独的内容区域（被称为
    目标视图），以及连接在应用程序当中各个“目标”的路径。
    NavHost:
    一个用于展示导航图当中目标视图的空的容器。Navigation组件包含一个实现NavHostFragment的默认的
    NavHost，它是用来展示fragment的目的地。
    NavController:
    管理NavHost中的应用程序导航的对象。 当用户在整个应用程序中移动时，NavController会协调NavHost中目
    标内容的交换。
Paging 分页组件    
    Paging 可以使开发者更轻松在 RecyclerView 中 分页加载数据
Room 保存本地数据到数据库中
    Database：包含数据库持有者，并作为与应用持久关联数据的底层连接的主要访问点。
    Entity：代表数据库中某个表的实体类。    
    DAO：包含用于访问数据库的方法。

[---]SQL
SQL 对大小写不敏感：SELECT 与 select 是相同的.
SQL 使用单引号来环绕文本值（大部分数据库系统也接受双引号）,如果是数值字段，请不要使用引号。
ctrl+q 新建查询,ctrl+r 运行
一些最重要的 SQL 命令:
    SELECT - 从数据库中提取数据
    UPDATE - 更新数据库中的数据
    DELETE - 从数据库中删除数据
    INSERT INTO - 向数据库中插入新数据
    CREATE DATABASE - 创建新数据库
    ALTER DATABASE - 修改数据库
    CREATE TABLE - 创建新表
    ALTER TABLE - 变更（改变）数据库表
    DROP TABLE - 删除表
    CREATE INDEX - 创建索引（搜索键）
    DROP INDEX - 删除索引
执行没有 WHERE 子句的 UPDATE 要慎重，再慎重
在 MySQL 中可以通过设置 sql_safe_updates 这个自带的参数来解决，当该参数开启的情况下，你必须在update 
    语句后携带 where 条件，且条件必须为key值，否则就会报错。
    set sql_safe_updates=1; 表示开启该参数
    set sql_safe_updates=0; 表示关闭该参数
BETWEEN：    
    请注意，在不同的数据库中，BETWEEN 操作符会产生不同的结果！
    在某些数据库中，BETWEEN 选取介于两个值之间但不包括两个测试值的字段。
    在某些数据库中，BETWEEN 选取介于两个值之间且包括两个测试值的字段。
    在某些数据库中，BETWEEN 选取介于两个值之间且包括第一个测试值但不包括最后一个测试值的字段。
    因此，请检查您的数据库是如何处理 BETWEEN 操作符！    
链接(JOIN)    
    左连接与右连接的左右指的是以两张表中的哪一张为基准，它们都是外连接。
    inner join <= min(left join, right join)
    full join >= max(left join, right join)
    当 inner join < min(left join, right join) 时， full join > max(left join, right join)
    INNER JOIN 与 JOIN 是相同的。
    在使用 join 时，on 和 where 条件的区别如下：
    on 条件是在生成临时表时使用的条件，它不管 on 中的条件是否为真，都会返回左边表中的记录。
    where 条件是在临时表生成好后，再对临时表进行过滤的条件。
    在某些数据库中，LEFT JOIN 称为 LEFT OUTER JOIN,RIGHT JOIN 称为 RIGHT OUTER JOIN.
    MySQL中不支持 FULL OUTER JOIN.
    UNION 只会选取不同的值。请使用 UNION ALL 来选取重复的值！
UNION 内部的每个 SELECT 语句必须拥有相同数量的列。列也必须拥有相似的数据类型。同时，每个 SELECT 语句
    中的列的顺序必须相同。    
MySQL 数据库不支持 SELECT ... INTO 语句，但支持 INSERT INTO ... SELECT 
    select into from 和 insert into select 都是用来复制表
    两者的主要区别为： select into from 要求目标表不存在，因为在插入时会自动创建,insert into select 
        from 要求目标表存在。    
    1. 复制表结构及其数据：
    create table table_name_new as select * from table_name_old
    2. 只复制表结构：
    create table table_name_new as select * from table_name_old where 1=2;
    或者：
    create table table_name_new like table_name_old
    3. 只复制表数据：
    如果两个表结构一样：
    insert into table_name_new select * from table_name_old
    如果两个表结构不一样：
    insert into table_name_new(column1,column2...) select column1,column2... from table_name_old        
GROUP BY 语句用于结合聚合函数，根据一个或多个列对结果集进行分组。
在 SQL 中增加 HAVING 子句原因是，WHERE 关键字无法与聚合函数一起使用。
JDBC代表Java数据库连接。
数据库URL配置见数据库URL配置.png
MYSQL-SQL语句分类:
    DQL（data query language）是数据查询语言：
        SELECT <字段名表>,FROM <表或视图名>,WHERE <查询条件>
    DML（data manipulation language）是数据操纵语言：
        （开发人员常用的命令）命令有SELECT、UPDATE、INSERT、DELETE，就象它的名字一样，这4条命令是用
        来对数据库里的表数据进行操作的语言。
    DDL（data definitionlanguage）是数据定义语言： 
        （DBA用,开发人员很少用）命令有show,ALTER，CREATE、DROP，等，DDL主要是用在对数据库实例、表、
        列等数据库对象的定义和操作。    
    DCL（DataControlLanguage）是数据库控制语言：
        （DBA用）是用来设置或更改数据库用户或角色权限的语句，包括（grant,deny,revoke等）语句。
DBMS：Database Management System数据库管理系统
URI，是uniform resource identifier，统一资源标识符，用来唯一的标识一个资源。        
请求报文: 由请求行、请求头部、空行和请求数据4部分组成        
响应:     由状态行、响应头部、空行和响应数据4部分组成
若connection 模式为close，则服务器主动关闭TCP连接，客户端被动关闭连接，释放TCP连接;若connection 模式
    为keepalive，则该连接会保持一段时间，在该时间内可以继续接收请求;
%E5%AD%99%E8%90%8D 解码后是 孙萍  这种属于URL编码和解码    
GET请求的参数会附在URL之后(请求报文第一部分)，POST请求的参数会放置在HTTP包的包体中(请求报文第三部分)
控制反转:IoC(Inversion of Control)是说创建对象的控制权进行转移，以前创建对象的主动权和创建时机是由自
    己把控的，而现在这种权力转移到第三方，比如转移交给了IoC容器,详情见链接:
    https://blog.csdn.net/qq_22654611/article/details/52606960/    
Bean的生命周期可以表达为：Bean的定义——Bean的初始化——Bean的使用——Bean的销毁 
Spring 方面可以使用下面提到的五种通知工作：
      通知	                    描述
    前置通知	    在一个方法执行之前，执行通知。
    后置通知	    在一个方法执行之后，不考虑其结果，执行通知。
    返回后通知	    在一个方法执行之后，只有在方法成功完成时，才能执行通知。
    抛出异常后通知	在一个方法执行之后，只有在方法退出抛出异常时，才能执行通知。
    环绕通知	    在建议方法调用之前和之后，执行通知。
DAO(Data Access Object) 数据访问对象.
delete from tablename删除数据后，自增ID还是从id+1开始算， truncate table tablename删除数据后，自增ID
    是从1开始算；   
POJO（Plain Ordinary Java Object）简单的Java对象，实际就是普通JavaBeans；
war文件：Web存档(war)文件包含Web应用程序的所有内容。它减少了传输文件所需要的时间。
AOP：Aspect Oriented Programming的缩写,面向切面编程
    AOP把软件系统分为两个部分：核心关注点和横切关注点。业务处理的主要流程是核心关注点，与之关系不大
    的部分是横切关注点。横切关注点的一个特点是，他们经常发生在核心关注点的多处，而各处基本相似，比如
    权限认证、日志、事物。AOP的作用在于分离系统中的各种关注点，将核心关注点和横切关注点分离开来。
接口映射器规则:
    1.将SQL定义文件<mapper>的namespace属性指定成包名.接口名
    2.根据Sql定义的id属性当接口方法名
    3.根据Sql定义的ParameterType类型当方法参数类型
    4.根据Sql定义的resultType类型定义方法返回参数，注：返回结果是多行使用List<T>泛型；单行使用T,泛型       
单元测试：是开发人员写好了一个简单的功能，从业务的角度来看就是完成了一个小功能我们去测试这个小功能。
    例如：我们编写好了一个登录功能或是一个用户信息展示功能，我们对这个小功能进行测试，就是单元测试。
单体测试：是开发人员编写好一个组件，从编程的角度来看就是完成了一小部分去测试这小部分。例如：我们在
    spingMVC项目中，编写好一个持久层组件，比如一个UserDao，我们对他进行测试，就是单体测试。
controller暴露接口、service处理数据、dao访问数据库，model就一个普通实体类，不能算在里面
@RestController注解相当于@ResponseBody ＋ @Controller合在一起的作用
    使用@Controller注解，在对应的方法上，视图解析器可以解析return的jsp,html页面，并且跳转到相应页面
    若返回json等内容到页面，则需要加@ResponseBody注解
互补配置：如果高优先级配置文件和低优先级配置文件都配置了某个属性，那么以高优先级的为准，如果低优先级
    配置文件配置了某个属性，而高优先级的没有配置，则低优先级配置文件的这个属性会生效。       
SSH 通常指的是 Struts2 做控制器(Action)，Spring 管理各层的组件，Hibernate 负责持久化层。
SSM 则指的是 SpringMVC 做控制器(controller)，Spring 管理各层的组件，MyBatis 负责持久化层。
       
[零碎知识]
String是字符串,它的比较用compareTo方法,它从第一位开始比较,如果遇到不同的字符,则马上返回这两个字符的
    ascii值差值.返回值是int类型
其中implementation仅对当前module依赖有效,api同compile,存在依赖的传递性.错误的使用则会导致依赖被加
    载两次,增加编译时间.
有时下载老版本的(比如API15)源码,是为了观看一些核心源码,因为一般情况下,同一个方法的源码,新版本的
    源码比老版本多很多,看源码很麻烦.        
静态内部类不可以访问直属父类里的方法和变量,但是可以访问直属父类里的接口和类,非静态内部类都可以访问.
继承中重写了方法，会先执行且肯定会执行最子类的该方法，若该子类方法中用了super关键字，才会调用直属父
    类的该方法，不管是不是向上转型，new的什么对象，那从该子类一直到最上面父类的getClass()都是该new出
    来的对象的class；   
在初始化时，“=”语句左边的是引用，右边new出来的是对象,所谓实例，其实就是对象的同义词,在Java中你所做
    的全部工作就是定义类，产生那些类的对象，以及发送消息给这些对象； 
Java语言提供了八种基本类型。六种数字类型（四个整数型，两个浮点型），一种字符类型，还有一种布尔型。
C和C++的“函数”一词和Java的“方法”一词是一个意思。    
与运算符和或运算符见basicTest方法；
只要类型比int小(即char，byte，short)，那么在运算之前，这些值会自动转换成int；通常，表达式中出现的最
    大的数据类型决定了表达式最终结果的数据类型，如果将一个float值与一个double值相乘，结果就是double，
    如果将一个int和一个long相加，则结果为long.
除了boolean以外，任何一种基本类型都可以通过类型转换变为其他基本类型，但是当类型转换成一种较小的类型
    时，必须留意信息丢失的问题。    
for循环执行顺序，初始化一次，然后：条件-->执行方法体-->步长，条件-->执行方法体-->步长，一直循环下去，
    直到条件为false时退出循环,见basicTest1方法.
如果在void的方法中没有return语句，那么在该方法的结尾处会有一个隐式的return；    
goto是Java中的保留字，但Java不可使用goto,然而，Java也能完成一些类似于跳转的操作，这与break，continue
    这两个关键词有关，它们三个使用了相同的机制：标签.
重载方法只能以类名和方法的形参列表作为标准，不能以方法的返回值作为标准，如下：
    void f(){}
    int f(){ return 1; }
    此时如果像下面这样调用方法：
    f();
    此时Java如何才能判断该调用哪一个f()呢？别人该如何理解这段代码呢？    
除了构造器之外，编译器禁止在其他任何方法中调用构造器。
使用垃圾回收器的唯一原因是为了回收程序不再使用的内存.所以对于与垃圾回收有关的任何行为来说(尤其是
    finalize()方法),它们也必须同内存及其回收有关.
可以肤浅的认为，正是由于垃圾收集机制的存在，使得Java没有析构函数(其实垃圾回收器的存在并不能完全代替
    析构函数);
无论是“垃圾回收”还是“终结”，都不保证一定会发生。如果Java虚拟机并未面临内存耗尽的情形，它是不会浪
    费时间去执行垃圾回收来恢复内存的。    
对于方法的局部变量，必须初始化，对于类的成员变量(即字段)，不用必须初始化，因为它有默认的初始值。
若类名直接调用静态方法，则执行顺序为：“静态块(static)和静态成员变量”定义的先后顺序决定了初始化顺序，
    最后调用静态方法。若new了一个对象，成员变量定义的先后顺序决定了初始化的顺序，即使成员变量定义散
    布于方法定义之间,它们仍旧会在任何方法(包括构造器)被调用之前得到初始化.静态变量和静态块(static)只
    执行一次，初始化是先初始化静态对象，再初始化非静态对象，见：MyElseTest-->getOrder方法.
尽量在构造器中初始化对象。
定义数组的两种方式：int[] a1;int a1[];两种格式的含义是一样的，后一种格式符合C和C++程序员的习惯。不过，
    前一种格式或许更合理，毕竟它表明类型时“一个int型数组”.
可变参数列表， private void printArr(Object... args)，见：MyElseTest-->getVarParam方法.
枚举类型的实例是常量,所以按照命名规范，它们都用大写字母表示(如果在一个名字中有多个单词，用下划线隔开)
重构即重写代码，以使得它更可读，更易理解，并因此而更具可维护性.
图：访问修饰符.jpg
控制对成员的访问权限有两个原因：
    1.为了使用户不要触碰那些他们不该触碰的部分,用private修饰
    2.让类库设计者可以更改类的内部工作方式，而不必担心这样会对客户端程序员产生重大的影响.
当创建一个类时，总是在继承，因此，除非已明确指出要从其他类中继承，否则就是在隐式地从Java的标准根类
    Object进行继承.
每一个非基本类型的对象都有一个toString()方法，该方法继承于Object;    
Java在调用子类的构造器中时，同时会自动调用默认的基类构造器.但是，如果没有默认的基类构造器就必须用关
    键字super显式地编写来调用基类构造器，并且配以适当的参数列表.
复用类：用于组合和继承.
组合：一个类由和另一个类的对象组成.
"is-a"(是一个)的关系是用继承来表达的，而"has-a"(有一个)的关系则是用组合来表达的.
执行类的所有特定的清理动作，其顺序和生成顺序相反(通常这就要求基类元素仍旧存活).见Java编程思想P159-8.3.2
必须在域的定义处或者每个构造器中对final进行赋值，这正是final域在使用前总是被初始化的原因所在.
当一个方法中的某个参数为final时，只能读该参数，不能修改该参数(不能赋值).
反射也不能修改final值.
多态通过分离做什么和怎么做，从另一角度将接口和实现分离开来.
Java的interface中，成员变量(常量)的默认修饰符为：public static final,方法的默认修饰符是：
    public abstract,并且不能是其他的修饰符，比如protected.接口没有toString方法.在Java SE5后，接口常
    量可以使用更加强大而灵活的enum来实现了.
extends只能继承一个类，但是接口可以通过extends继承多个其他接口.
Log类只会打印4000个字符，超过部分不打印！！！
传入new创建的对象是地址传递，基本数据类型是值传递，见elseTest2-->MyElseTest1-->testSite()
PascalCase大驼峰式命名法：MyComponent
kebab-case短横线隔开式命名法：my-component
camelCase小驼峰式命名法：myComponent
ActivityThread 的 main 是一个App的入口，并且Looper的准备和开启已经在main方法中使用了
    (// 准备主线程的LooperLooper.prepareMainLooper();// 开启LooperLooper.loop();)，所以我们在主线程
    不需要先进行 Looper 的准备和开启

