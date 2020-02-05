package top.xiamuyao.fastspringdevelop

import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException
import com.baomidou.mybatisplus.core.toolkit.StringPool
import com.baomidou.mybatisplus.core.toolkit.StringUtils
import com.baomidou.mybatisplus.generator.AutoGenerator
import com.baomidou.mybatisplus.generator.InjectionConfig
import com.baomidou.mybatisplus.generator.config.*
import com.baomidou.mybatisplus.generator.config.po.TableInfo
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine
import java.util.*

/**
 * ================================================
 * 作    者：夏沐尧  Github地址：https://github.com/XiaMuYaoDQX
 * 版    本：1.0
 * 创建日期：2018/9/21
 * 描    述：
 * 修订历史：
 * ================================================
 */
object CodeGenerator {
    private const val AUTHOR = "XiaMuYao"
    private const val DATABASE = "toast"
    private const val DATABASE_USERNAME = "root"
    private const val DATABASE_PASSWORD = "LoPickHcgXmy123."
    private const val PROJECT = "top.xiamuyao.fastspringdevelop"
    private const val ADDRESS = "39.97.251.220:3306"
    /**
     *
     *
     * 读取控制台内容
     *
     */
    fun scanner(tip: String): String {
        val scanner = Scanner(System.`in`)
        val help = StringBuilder()
        help.append("请输入$tip：")
        println(help.toString())
        if (scanner.hasNext()) {
            val ipt = scanner.next()
            if (StringUtils.isNotEmpty(ipt)) {
                return ipt
            }
        }
        throw MybatisPlusException("请输入正确的$tip！")
    }

    @JvmStatic
    fun main(args: Array<String>) { // 代码生成器
        val mpg = AutoGenerator()
        // 全局配置
        val gc = GlobalConfig()
        val projectPath = System.getProperty("user.dir")
        gc.outputDir = "$projectPath/src/main/java"
        gc.author = AUTHOR
        gc.isOpen = false
        mpg.globalConfig = gc
        // 数据源配置
        val dsc = DataSourceConfig()
        dsc.url = "jdbc:mysql://$ADDRESS/$DATABASE?useUnicode=true&characterEncoding=UTF-8&allowMultiQueries=true"
        // dsc.setSchemaName("public");
        dsc.driverName = "com.mysql.jdbc.Driver"
        dsc.username = DATABASE_USERNAME
        dsc.password = DATABASE_PASSWORD
        mpg.dataSource = dsc
        // 包配置
        val pc = PackageConfig()
        pc.moduleName = scanner("模块名")
        pc.parent = PROJECT
        mpg.packageInfo = pc
        // 自定义配置
        val cfg: InjectionConfig = object : InjectionConfig() {
            override fun initMap() { // to do nothing
            }
        }
        val focList: MutableList<FileOutConfig> = ArrayList()
        focList.add(object : FileOutConfig("/templates/mapper.xml.ftl") {
            override fun outputFile(tableInfo: TableInfo): String { // 自定义输入文件名称
                return (projectPath + "/src/main/resources/mapper/" + pc.moduleName
                        + "/" + tableInfo.entityName + "Mapper" + StringPool.DOT_XML)
                //                return projectPath + "/src/main/resources/mapper/"
//                        + "/" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
            }
        })
        cfg.fileOutConfigList = focList
        mpg.cfg = cfg
        mpg.template = TemplateConfig().setXml(null)
        // 策略配置
        val strategy = StrategyConfig()
        strategy.naming = NamingStrategy.underline_to_camel
        strategy.columnNaming = NamingStrategy.underline_to_camel
        //        strategy.setSuperEntityClass("com.baomidou.ant.common.BaseEntity");
        strategy.isEntityLombokModel = true
        strategy.isRestControllerStyle = true
        //        strategy.setSuperControllerClass("com.baomidou.ant.common.BaseController");
        strategy.setInclude(scanner("表名"))
        //        strategy.setSuperEntityColumns("id");
        strategy.isControllerMappingHyphenStyle = true
        strategy.setTablePrefix(pc.moduleName + "_")
        mpg.strategy = strategy
        mpg.templateEngine = FreemarkerTemplateEngine()
        mpg.execute()
    }
}