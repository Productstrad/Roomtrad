CREATE DATABASE  IF NOT EXISTS `tradeproduct` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `tradeproduct`;
-- MySQL dump 10.13  Distrib 5.6.17, for Win32 (x86)
--
-- Host: localhost    Database: tradeproduct
-- ------------------------------------------------------
-- Server version	5.1.49-community

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `trade_department`
--

DROP TABLE IF EXISTS `trade_department`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `trade_department` (
  `DeptID` int(11) NOT NULL AUTO_INCREMENT COMMENT '组织ID',
  `DeptName` varchar(30) NOT NULL COMMENT '组织名称',
  `DeptDescription` varchar(200) DEFAULT '''''' COMMENT '组织描述',
  `ParentID` int(11) DEFAULT NULL COMMENT '父组织ID',
  `CreateUserID` int(11) DEFAULT '0' COMMENT '创建者ID',
  `CreateDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `ModifyUserID` int(11) DEFAULT '0' COMMENT '修改者ID',
  `ModifyDate` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '修改时间',
  `RecordStatus` varchar(200) DEFAULT NULL COMMENT '记录状态',
  `IsDeleted` tinyint(4) DEFAULT '0',
  PRIMARY KEY (`DeptID`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `trade_department`
--

LOCK TABLES `trade_department` WRITE;
/*!40000 ALTER TABLE `trade_department` DISABLE KEYS */;
INSERT INTO `trade_department` VALUES (1,'web开发部门','开发互联网应用',0,NULL,'2014-07-14 08:57:12',NULL,'2014-07-14 08:57:12',NULL,0),(2,'Silverlight部门','开发Silverlight富媒体应用',1,NULL,'2014-07-14 08:57:12',NULL,'2014-07-14 08:57:12',NULL,0),(3,'asp.net部门','开发asp.net网站',1,NULL,'2014-07-14 08:57:12',NULL,'2014-07-14 08:57:12',NULL,0),(4,'jsp部门','开发jsp网站',1,NULL,'2014-07-14 08:57:12',NULL,'2014-07-14 08:57:12',NULL,0),(5,'php部门','开发php网站',1,4,'2012-08-09 13:44:32',4,'2012-08-09 13:44:32',NULL,0),(6,'销售部','销售活动',0,NULL,'2014-07-14 08:57:12',NULL,'2014-07-14 08:57:12',NULL,0),(7,'外联部','搞联谊1',0,1,'2012-07-20 16:45:40',1,'2012-07-20 16:45:40',NULL,0),(8,'人力资源部','负责人力资源管理',0,NULL,'2014-07-14 08:57:12',NULL,'2014-07-14 08:57:12',NULL,0),(9,'测试部','测试部门',1,NULL,'2014-07-14 08:57:12',NULL,'2014-07-14 08:57:12',NULL,0),(10,'开发部','web开发部门',0,NULL,'2014-07-14 08:57:12',NULL,'2014-07-14 08:57:12',NULL,0),(11,'销售部','销售部门',0,NULL,'2014-07-14 08:57:12',NULL,'2014-07-14 08:57:12',NULL,0),(12,'.net开发小组','.net开发小组',1,NULL,'2014-07-14 08:57:12',NULL,'2014-07-14 08:57:12',NULL,0),(13,'WPF开发小组','WPF开发',1,NULL,'2014-07-14 08:57:12',NULL,'2014-07-14 08:57:12',NULL,0),(14,'tzh','4445',0,1,'2012-07-20 16:54:27',1,'2012-07-20 16:54:27',NULL,0),(15,'111发发发','份额份额',1,1,'2012-07-23 15:39:54',1,'2012-07-23 15:39:54',NULL,0),(19,'34511','52411',9,1,'2014-06-18 09:09:16',1,'2014-06-18 09:09:16',NULL,0);
/*!40000 ALTER TABLE `trade_department` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `trade_favorite`
--

DROP TABLE IF EXISTS `trade_favorite`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `trade_favorite` (
  `FavoriteID` int(11) NOT NULL DEFAULT '0',
  `FavoriteTitle` varchar(50) DEFAULT NULL,
  `FavoriteAddTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `FavoriteContent` varchar(200) DEFAULT NULL,
  `UserID` int(11) DEFAULT NULL,
  `Url` varchar(100) DEFAULT NULL,
  `Icon` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`FavoriteID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `trade_favorite`
--

LOCK TABLES `trade_favorite` WRITE;
/*!40000 ALTER TABLE `trade_favorite` DISABLE KEYS */;
INSERT INTO `trade_favorite` VALUES (5,'系统日志管理','2012-08-08 12:33:19','我的日志记录',1,'/Admin/OperateLog/Index','/Content/icons/32X32/project.gif'),(6,'菜单管理','2012-08-08 12:37:35','',1,'/Admin/Menus/Index','/Content/icons/32X32/sitemap.gif');
/*!40000 ALTER TABLE `trade_favorite` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `trade_module`
--

DROP TABLE IF EXISTS `trade_module`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `trade_module` (
  `ModuleID` int(11) NOT NULL DEFAULT '0',
  `ModuleName` varchar(30) DEFAULT NULL,
  `ModuleLinkUrl` varchar(100) DEFAULT NULL,
  `ModuleIcon` varchar(100) DEFAULT NULL,
  `ParentNo` int(11) DEFAULT NULL,
  `Sort` int(11) DEFAULT NULL,
  `IsVisible` tinyint(4) DEFAULT NULL,
  `IsLeaf` tinyint(4) DEFAULT NULL,
  `IsMenu` tinyint(4) DEFAULT NULL,
  `IsDeleted` tinyint(4) DEFAULT NULL,
  `ModuleController` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`ModuleID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `trade_module`
--

LOCK TABLES `trade_module` WRITE;
/*!40000 ALTER TABLE `trade_module` DISABLE KEYS */;
INSERT INTO `trade_module` VALUES (1,'系统管理',NULL,'/Content/icons/32X32/settings.gif',0,55,1,0,1,0,NULL),(2,'部门管理','/Admin/Department/Index','/Content/icons/32X32/customers.gif',5,66,1,1,1,0,'Department'),(3,'用户管理','/Admin/User/Index','/Content/icons/32X32/user.gif',5,5,1,1,1,0,'User'),(4,'角色管理','/Admin/Role/Index','/Content/icons/32X32/role.gif',5,6,1,NULL,1,0,'Role'),(5,'组织架构',NULL,'/Content/icons/32X32/sitemap.gif',0,3,1,NULL,1,0,NULL),(8,'系统日志管理','/Admin/OperateLog/Index','/Content/icons/32X32/project.gif',1,5,1,1,1,0,'OperateLog'),(9,'菜单管理','/Admin/Menus/Index','/Content/icons/32X32/sitemap.gif',1,55,1,1,1,0,'Menus'),(11,'系统权限维护','/Admin/Button/Index','/Content/icons/32X32/config.gif',1,10,1,NULL,1,0,'Button'),(23,'菜单按钮管理','/Admin/MenusButtonsManage/Index','/Content/icons/32X32/feed.gif',1,10,1,NULL,0,0,'MenusButtonsManage'),(24,'角色权限管理','/Admin/RolePermission/Index','/Content/icons/32X32/setup.gif',1,55,1,0,1,0,'RolePermission'),(25,'124','/Admin/SystemInfo/Index','/Content/icons/32X32/networking.gif',1,NULL,1,NULL,0,0,'SystemInfo');
/*!40000 ALTER TABLE `trade_module` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `trade_modulepermission`
--

DROP TABLE IF EXISTS `trade_modulepermission`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `trade_modulepermission` (
  `ModulePermissionID` bigint(20) NOT NULL DEFAULT '0',
  `ModuleID` int(11) DEFAULT NULL,
  `PermissionID` int(11) DEFAULT NULL,
  `CreateUserID` int(11) DEFAULT NULL,
  `CreateDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `ModifyUserID` int(11) DEFAULT NULL,
  `ModifyDate` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `RecordStatus` varchar(200) DEFAULT NULL,
  `IsDeleted` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`ModulePermissionID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `trade_modulepermission`
--

LOCK TABLES `trade_modulepermission` WRITE;
/*!40000 ALTER TABLE `trade_modulepermission` DISABLE KEYS */;
INSERT INTO `trade_modulepermission` VALUES (1,2,3,NULL,'2014-07-14 08:57:12',NULL,'2014-07-14 08:57:12',NULL,0),(2,2,4,NULL,'2014-07-14 08:57:12',NULL,'2014-07-14 08:57:12',NULL,0),(3,2,1,NULL,'2014-07-14 08:57:12',NULL,'2014-07-14 08:57:12',NULL,0),(4,2,2,NULL,'2014-07-14 08:57:12',NULL,'2014-07-14 08:57:12',NULL,0),(5,8,15,NULL,'2014-07-14 08:57:12',NULL,'2014-07-14 08:57:12',NULL,0),(6,8,5,NULL,'2014-07-14 08:57:12',NULL,'2014-07-14 08:57:12',NULL,0),(7,8,18,1,'2012-07-30 03:36:02',1,'2012-07-30 03:36:02',NULL,1),(8,9,8,NULL,'2014-07-14 08:57:12',NULL,'2014-07-14 08:57:12',NULL,0),(9,9,20,NULL,'2014-07-14 08:57:12',NULL,'2014-07-14 08:57:12',NULL,0),(10,9,21,NULL,'2014-07-14 08:57:12',NULL,'2014-07-14 08:57:12',NULL,0),(11,9,22,NULL,'2014-07-14 08:57:12',NULL,'2014-07-14 08:57:12',NULL,0),(12,11,24,NULL,'2014-07-14 08:57:12',NULL,'2014-07-14 08:57:12',NULL,0),(13,11,25,NULL,'2014-07-14 08:57:12',NULL,'2014-07-14 08:57:12',NULL,0),(14,11,26,NULL,'2014-07-14 08:57:12',NULL,'2014-07-14 08:57:12',NULL,0),(15,11,27,NULL,'2014-07-14 08:57:12',NULL,'2014-07-14 08:57:12',NULL,0),(16,9,33,NULL,'2014-07-14 08:57:12',NULL,'2014-07-14 08:57:12',NULL,0),(17,23,35,NULL,'2014-07-14 08:57:12',NULL,'2014-07-14 08:57:12',NULL,0),(18,23,36,NULL,'2014-07-14 08:57:12',NULL,'2014-07-14 08:57:12',NULL,0),(19,23,37,NULL,'2014-07-14 08:57:12',NULL,'2014-07-14 08:57:12',NULL,0),(20,23,38,NULL,'2014-07-14 08:57:12',NULL,'2014-07-14 08:57:12',NULL,0),(27,4,41,NULL,'2014-07-14 08:57:12',NULL,'2014-07-14 08:57:12',NULL,0),(28,4,42,NULL,'2014-07-14 08:57:12',NULL,'2014-07-14 08:57:12',NULL,0),(29,4,43,NULL,'2014-07-14 08:57:12',NULL,'2014-07-14 08:57:12',NULL,0),(30,4,44,NULL,'2014-07-14 08:57:12',NULL,'2014-07-14 08:57:12',NULL,0),(31,3,51,NULL,'2014-07-14 08:57:12',NULL,'2014-07-14 08:57:12',NULL,0),(32,3,52,NULL,'2014-07-14 08:57:12',NULL,'2014-07-14 08:57:12',NULL,0),(33,3,53,NULL,'2014-07-14 08:57:12',NULL,'2014-07-14 08:57:12',NULL,0),(34,3,54,NULL,'2014-07-14 08:57:12',NULL,'2014-07-14 08:57:12',NULL,0),(35,2,55,NULL,'2014-07-14 08:57:12',NULL,'2014-07-14 08:57:12',NULL,0),(36,3,58,NULL,'2014-07-14 08:57:12',NULL,'2014-07-14 08:57:12',NULL,0),(37,11,56,NULL,'2014-07-14 08:57:12',NULL,'2014-07-14 08:57:12',NULL,0),(38,8,57,NULL,'2014-07-14 08:57:12',NULL,'2014-07-14 08:57:12',NULL,0),(39,9,60,NULL,'2014-07-14 08:57:12',NULL,'2014-07-14 08:57:12',NULL,0),(40,23,61,NULL,'2014-07-14 08:57:12',NULL,'2014-07-14 08:57:12',NULL,0),(41,24,70,NULL,'2014-07-14 08:57:12',NULL,'2014-07-14 08:57:12',NULL,0),(42,24,71,NULL,'2014-07-14 08:57:12',NULL,'2014-07-14 08:57:12',NULL,0);
/*!40000 ALTER TABLE `trade_modulepermission` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `trade_operatelog`
--

DROP TABLE IF EXISTS `trade_operatelog`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `trade_operatelog` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `ProcessName` varchar(50) DEFAULT NULL,
  `ProcessDesc` varchar(100) DEFAULT NULL,
  `MethodName` varchar(50) DEFAULT NULL,
  `UserID` int(11) DEFAULT NULL,
  `UserName` varchar(30) DEFAULT NULL,
  `IPAddress` varchar(100) DEFAULT NULL,
  `Description` varchar(200) DEFAULT NULL,
  `CreateDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `MethodDesc` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `trade_operatelog`
--

LOCK TABLES `trade_operatelog` WRITE;
/*!40000 ALTER TABLE `trade_operatelog` DISABLE KEYS */;
INSERT INTO `trade_operatelog` VALUES (2,'OperateLog',NULL,'Index',1,'TZHSWEET                      ','::1','浏览[操作日志管理]','2012-07-22 01:48:16',NULL),(3,'OperateLog',NULL,'Index',1,'TZHSWEET                      ','::1','浏览[操作日志管理]','2012-07-22 02:35:20',NULL),(4,'OperateLog',NULL,'Index',1,'TZHSWEET                      ','::1','浏览[操作日志管理]','2012-07-22 02:36:13',NULL),(5,'OperateLog',NULL,'Index',1,'TZHSWEET                      ','::1','浏览[操作日志管理]','2012-07-22 02:37:00',NULL),(6,'OperateLog',NULL,'Index',1,'TZHSWEET                      ','::1','浏览[操作日志管理]','2012-07-22 02:37:50',NULL),(7,'OperateLog',NULL,'Index',1,'TZHSWEET                      ','::1','浏览[操作日志管理]','2012-07-22 02:38:18',NULL),(8,'OperateLog',NULL,'Index',1,'TZHSWEET                      ','::1','浏览[操作日志管理]','2012-07-22 02:43:28',NULL),(9,'OperateLog',NULL,'Index',1,'TZHSWEET                      ','::1','浏览[操作日志管理]','2012-07-22 02:45:23',NULL),(10,'OperateLog',NULL,'DeleteThreeMonthLog',1,'TZHSWEET                      ','::1','清空日志:清空日志成功!','2012-07-22 02:45:27',NULL),(11,'OperateLog',NULL,'Index',1,'TZHSWEET                      ','::1','浏览[操作日志管理]','2012-07-22 04:21:27',NULL),(12,'OperateLog',NULL,'Index',1,'TZHSWEET                      ','::1','浏览[操作日志管理]','2012-07-22 04:22:21',NULL),(13,'OperateLog',NULL,'Index',1,'TZHSWEET                      ','::1','浏览[操作日志管理]','2012-07-22 04:22:45',NULL),(14,'OperateLog',NULL,'Index',1,'TZHSWEET                      ','::1','浏览[操作日志管理]','2012-07-22 04:23:33',NULL),(15,'OperateLog',NULL,'Index',1,'TZHSWEET                      ','::1','浏览[操作日志管理]','2012-07-22 04:23:46',NULL),(16,'OperateLog',NULL,'Index',1,'TZHSWEET                      ','::1','浏览[操作日志管理]','2012-07-22 04:24:33',NULL),(17,'OperateLog',NULL,'Index',1,'TZHSWEET                      ','::1','浏览[操作日志管理]','2012-07-22 04:30:09',NULL),(18,'OperateLog',NULL,'Index',1,'TZHSWEET                      ','::1','浏览[操作日志管理]','2012-07-22 04:33:00',NULL),(19,'OperateLog',NULL,'Index',1,'TZHSWEET                      ','::1','浏览[操作日志管理]','2012-07-22 06:33:43',NULL),(20,'OperateLog',NULL,'Index',1,'TZHSWEET                      ','::1','浏览[操作日志管理]','2012-07-22 06:42:05',NULL),(21,'OperateLog',NULL,'Index',1,'TZHSWEET                      ','::1','浏览[操作日志管理]','2012-07-22 06:48:48',NULL),(22,'OperateLog',NULL,'Index',1,'TZHSWEET                      ','::1','浏览[操作日志管理]','2012-07-22 08:23:47',NULL),(23,'OperateLog',NULL,'Index',1,'TZHSWEET                      ','::1','浏览[操作日志管理]','2012-07-22 13:37:49',NULL),(24,'OperateLog',NULL,'Index',1,'TZHSWEET                      ','::1','浏览[操作日志管理]','2012-07-22 14:39:47',NULL),(25,'OperateLog',NULL,'Index',1,'TZHSWEET                      ','::1','浏览[操作日志管理]','2012-07-22 14:41:45',NULL),(26,'OperateLog',NULL,'Index',1,'TZHSWEET                      ','::1','浏览[操作日志管理]','2012-07-22 14:42:01',NULL),(27,'OperateLog',NULL,'Index',1,'TZHSWEET                      ','::1','浏览[操作日志管理]','2012-07-22 14:45:33',NULL),(28,'OperateLog',NULL,'Index',1,'TZHSWEET                      ','::1','浏览[操作日志管理]','2012-07-22 14:48:15',NULL),(29,'OperateLog',NULL,'Index',1,'TZHSWEET                      ','::1','浏览[操作日志管理]','2012-07-22 15:43:56',NULL),(30,'OperateLog',NULL,'Index',1,'TZHSWEET                      ','::1','浏览[操作日志管理]','2012-07-22 15:50:21',NULL),(31,'OperateLog',NULL,'Index',1,'TZHSWEET                      ','::1','浏览[操作日志管理]','2012-07-22 16:12:33',NULL),(32,'OperateLog',NULL,'Index',1,'TZHSWEET                      ','::1','浏览[操作日志管理]','2012-07-22 16:40:32',NULL),(33,'OperateLog',NULL,'Index',1,'TZHSWEET                      ','::1','浏览[操作日志管理]','2012-07-22 16:41:44',NULL),(34,'OperateLog',NULL,'Index',1,'TZHSWEET                      ','::1','浏览[操作日志管理]','2012-07-22 16:42:59',NULL),(35,'OperateLog',NULL,'Index',1,'TZHSWEET                      ','::1','浏览[操作日志管理]','2012-07-22 16:50:21',NULL),(36,'OperateLog',NULL,'Index',1,'TZHSWEET                      ','::1','浏览[操作日志管理]','2012-07-22 17:11:14',NULL);
/*!40000 ALTER TABLE `trade_operatelog` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `trade_permission`
--

DROP TABLE IF EXISTS `trade_permission`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `trade_permission` (
  `PermissionID` int(11) NOT NULL AUTO_INCREMENT,
  `PermissionAction` varchar(30) DEFAULT NULL,
  `PermissionName` varchar(30) DEFAULT NULL,
  `Sort` int(11) DEFAULT NULL,
  `IsVisible` tinyint(4) DEFAULT NULL,
  `Script` varchar(100) DEFAULT NULL,
  `Icon` varchar(100) DEFAULT NULL,
  `PermissionController` varchar(30) DEFAULT NULL,
  `Description` varchar(200) DEFAULT NULL,
  `IsButton` tinyint(4) DEFAULT NULL,
  `ParentID` int(11) DEFAULT NULL,
  PRIMARY KEY (`PermissionID`)
) ENGINE=InnoDB AUTO_INCREMENT=81 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `trade_permission`
--

LOCK TABLES `trade_permission` WRITE;
/*!40000 ALTER TABLE `trade_permission` DISABLE KEYS */;
INSERT INTO `trade_permission` VALUES (1,'Detail','查看部门详情',NULL,1,NULL,'/Content/icons/silkicons/application_view_detail.png','Department','[Detail主页]浏览部门详细信息',1,55),(2,'Update','修改部门',NULL,1,NULL,'/Content/icons/silkicons/application_edit.png','Department','[Index页面Update请求]更新部门',1,55),(3,'Add','添加部门',NULL,1,NULL,'/Content/icons/silkicons/add.png','Department','[Index页面Add请求]添加部门',1,55),(4,'Delete','删除部门',NULL,1,NULL,'/Content/icons/silkicons/delete.png','Department','[Index页面Delete请求]删除(假删)部门',1,55),(5,'DeleteThreeMonthLog','清空日志',NULL,1,NULL,'/Content/icons/silkicons/book_delete.png','OperateLog','[Index页面删除请求]清空三个月以前的日志',1,57),(8,'RealDelete','永久删除菜单',NULL,1,NULL,'/Content/icons/silkicons/application_delete.png','Menus','[Index页面永久删除请求]永久删除',1,60),(15,'Detail','查看日志详情',NULL,1,NULL,'/Content/icons/silkicons/application_view_detail.png','OperateLog','[Detail主页]查看日志详情(Detail必须)',1,57),(18,'GetLogsGrid','获取日志列表信息',NULL,1,NULL,'/Content/icons/silkicons/delete.png','OperateLog','[Index页面Grid请求]获取系统操作日志信息(首页必须)',0,57),(20,'Update','修改菜单',NULL,1,NULL,'/Content/icons/silkicons/application_edit.png','Menus','[Index页面Update更新请求]更新菜单',1,60),(21,'Add','添加菜单',NULL,1,NULL,'/Content/icons/silkicons/add.png','Menus','[Index页面Add添加请求]添加菜单',1,60),(22,'Delete','删除菜单',NULL,1,NULL,'/Content/icons/silkicons/delete.png','Menus','[Index页面Delete删除请求]删除',1,60),(24,'Update','修改',NULL,1,NULL,'/Content/icons/silkicons/application_edit.png','Button','[系统权限维护页]修改动作',1,56),(25,'Add','添加',NULL,1,NULL,'/Content/icons/silkicons/add.png','Button','[系统权限维护页]添加动作',1,56),(26,'Delete','删除',NULL,1,NULL,'/Content/icons/silkicons/delete.png','Button','[系统权限维护页]软删除动作',1,56),(27,'RealDelete','永久删除',NULL,1,NULL,'/Content/icons/silkicons/application_delete.png','Button','[系统权限维护页]永久删除动作',1,56),(33,'MenuButtonConfig','菜单按钮管理',NULL,1,NULL,'/Content/icons/silkicons/cog.png','Menus','[Index页面跳转]菜单按钮管理',1,60),(35,'RealDelete','永久删除',NULL,1,NULL,'/Content/icons/silkicons/application_delete.png','MenusButtonsManage','[菜单按钮管理主页]永久删除动作',1,61),(36,'Update','修改',NULL,1,NULL,'/Content/icons/silkicons/application_edit.png','MenusButtonsManage','[菜单按钮管理主页]修改请求',1,61),(37,'Add','添加',NULL,1,NULL,'/Content/icons/silkicons/add.png','MenusButtonsManage','[菜单按钮管理主页]添加请求',1,61),(38,'Delete','删除',NULL,1,NULL,'/Content/icons/silkicons/delete.png','MenusButtonsManage','[菜单按钮管理主页]删除(假删除)',1,61),(41,'Add','添加角色',NULL,1,NULL,'/Content/icons/silkicons/application_edit.png','Role','[角色管理首页]添加角色',1,59),(42,'Update','修改角色',NULL,1,NULL,'/Content/icons/silkicons/add.png','Role','[角色管理首页]修改角色',1,59),(43,'Delete','删除',NULL,1,NULL,'/Content/icons/silkicons/delete.png','Role','[角色管理首页]删除(假删)角色',1,59),(44,'RealDelete','永久删除',NULL,1,NULL,'/Content/icons/silkicons/application_delete.png','Role','[角色管理首页]永久删除角色',1,59),(51,'Detail','查看详情',NULL,1,NULL,'/Content/icons/silkicons/application_view_detail.png','User','[用户详细信息]详细信息(add,Update,Detail必备)',1,58),(52,'Update','修改',NULL,1,NULL,'/Content/icons/silkicons/application_edit.png','User','[用户详细信息]更新用户',1,58),(53,'Add','添加',NULL,1,NULL,'/Content/icons/silkicons/add.png','User','[用户详细信息]添加用户',1,58),(54,'Delete','删除',NULL,1,NULL,'/Content/icons/silkicons/delete.png','User','[用户详细信息]删除用户',1,58),(55,'Index','访问部门管理',NULL,1,NULL,'/Content/icons/32X32/customers.gif','Department','[Index主页]部门管理',0,0),(56,'Index','访问权限维护',NULL,1,NULL,'/Content/icons/32X32/feed.gif','Button','[系统权限维护页]按钮管理',0,0),(57,'Index','访问日志管理',NULL,1,NULL,'/Content/icons/32X32/project.gif','OperateLog','[Index主页]系统操作日志管理',0,0),(58,'Index','访问用户信息',NULL,1,NULL,'/Content/icons/32X32/user.gif','User','[用户管理首页]列表信息',0,0),(59,'Index','访问角色管理',NULL,1,NULL,'/Content/icons/32X32/role.gif','Role','[角色管理首页]',0,0),(60,'Index','访问菜单管理',NULL,1,NULL,'/Content/icons/32X32/sitemap.gif','Menus','[Index主页]菜单管理',0,0),(61,'Index','访问菜单按钮管理',NULL,1,NULL,'/Content/icons/32X32/feed.gif','MenusButtonsManage','[菜单按钮管理主页]',0,0),(70,'Index','访问角色权限管理',NULL,1,NULL,'/Content/icons/32X32/setup.gif','RolePermission','角色权限管理',0,0),(71,'GrantRolePermission','授予权限',NULL,1,NULL,'/Content/icons/silkicons/table_gear.png','RolePermission','授予角色权限',1,70),(73,'GetDeptGridTree','获取部门GridTree树信息',NULL,1,NULL,'/Content/icons/32X32/communication.gif','Department','[Index页面GridTree Ajax请求]获取部门GridTree树信息(主页必须)',0,55),(74,'GetDeptSelect','获取部门列表下拉框信息',NULL,1,NULL,'/Content/icons/32X32/shipping.gif','Department','[Detail页面Select Ajax请求]获取部门的下拉列表框(Detail,Update,Add必须)',0,55),(75,'Get','获取一条部门记录信息',NULL,1,NULL,'/Content/icons/32X32/shipping.gif','Department','[Detail页面加载表单请求]获取一条部门信息(Detail,Update必须)',0,55),(76,'GetDepartmentTree','部门下拉框请求',NULL,1,NULL,'/Content/icons/32X32/shipping.gif','Department','部门树级下拉框请求',0,55),(77,'GetPermissionForGrid','获取权限信息',NULL,1,NULL,'/Content/icons/32X32/communication.gif','Button','[系统权限维护页Ajax请求]请求权限功能列表信息(返回Grid)(主页必须)',0,56),(78,'SelectAction','选择动作主页',NULL,1,NULL,'/Content/icons/32X32/feed.gif','Button','[选择动作页面]请求动作信息页面(Add和Update必须)',0,56),(79,'GetAllAction','获取所有动作信息',NULL,1,NULL,'/Content/icons/32X32/feed.gif','Button','[选择动作页面Grid Ajax请求]请求所有控制器的动作信息(Add和Update必须)',0,78),(80,'Get','获取一条日志信息',NULL,1,NULL,'/Content/icons/32X32/limited_edition.gif','OperateLog','[Detail页面Load一条日志请求]获取一条日志信息(Detail必须)',0,57);
/*!40000 ALTER TABLE `trade_permission` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `trade_role`
--

DROP TABLE IF EXISTS `trade_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `trade_role` (
  `RoleID` int(11) NOT NULL AUTO_INCREMENT,
  `RoleNo` varchar(30) DEFAULT NULL,
  `RoleName` varchar(30) DEFAULT NULL,
  `Description` varchar(200) DEFAULT NULL,
  `Sort` int(11) DEFAULT NULL,
  `IsVisible` tinyint(4) DEFAULT NULL,
  `CreateUserID` int(11) DEFAULT NULL,
  `CreateDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `ModifyUserID` int(11) DEFAULT NULL,
  `ModifyDate` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `RecordStatus` varchar(200) DEFAULT NULL,
  `IsDeleted` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`RoleID`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `trade_role`
--

LOCK TABLES `trade_role` WRITE;
/*!40000 ALTER TABLE `trade_role` DISABLE KEYS */;
INSERT INTO `trade_role` VALUES (1,'Administrator','超级管理员','管理超级人 ',NULL,1,NULL,'2014-07-14 08:57:13',NULL,'2014-07-14 08:57:13',NULL,0),(2,'sa','普通管理员','管理普通人 ',NULL,1,NULL,'2014-07-14 08:57:13',NULL,'2014-07-14 08:57:13',NULL,0),(3,'edit','新闻编辑','编辑新闻',NULL,1,NULL,'2014-07-14 08:57:13',NULL,'2014-07-14 08:57:13',NULL,0),(4,'laji','会计','记账的 ',NULL,1,NULL,'2014-07-14 08:57:13',NULL,'2014-07-14 08:57:13',NULL,0),(5,'tzzj','12455','124',NULL,0,NULL,'2014-07-14 08:57:13',1,'2012-07-30 13:56:59',NULL,1),(6,'sa','12412','214124',NULL,1,1,'2012-08-08 10:37:30',1,'2012-08-08 10:37:30',NULL,0),(7,'开发者','开发者','',NULL,1,1,'2012-08-09 08:15:07',1,'2012-08-09 08:15:07',NULL,0),(8,'manager','总经理','总经理',NULL,1,NULL,'2014-07-14 08:57:13',1,'2014-06-18 09:11:05',NULL,0);
/*!40000 ALTER TABLE `trade_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `trade_rolepermission`
--

DROP TABLE IF EXISTS `trade_rolepermission`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `trade_rolepermission` (
  `RolePermissionID` bigint(20) NOT NULL AUTO_INCREMENT,
  `RoleID` int(11) DEFAULT NULL,
  `ModulePermissionID` bigint(20) DEFAULT NULL,
  `CreateUserID` int(11) DEFAULT NULL,
  `CreateDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `ModifyUserID` int(11) DEFAULT NULL,
  `ModifyDate` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `RecordStatus` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`RolePermissionID`)
) ENGINE=InnoDB AUTO_INCREMENT=95 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `trade_rolepermission`
--

LOCK TABLES `trade_rolepermission` WRITE;
/*!40000 ALTER TABLE `trade_rolepermission` DISABLE KEYS */;
INSERT INTO `trade_rolepermission` VALUES (1,1,1,NULL,'2014-07-14 08:57:13',NULL,'2014-07-14 08:57:13',NULL),(2,1,2,NULL,'2014-07-14 08:57:13',NULL,'2014-07-14 08:57:13',NULL),(3,1,3,NULL,'2014-07-14 08:57:13',NULL,'2014-07-14 08:57:13',NULL),(4,1,4,NULL,'2014-07-14 08:57:13',NULL,'2014-07-14 08:57:13',NULL),(5,1,5,NULL,'2014-07-14 08:57:13',NULL,'2014-07-14 08:57:13',NULL),(6,1,6,NULL,'2014-07-14 08:57:13',NULL,'2014-07-14 08:57:13',NULL),(7,1,7,NULL,'2014-07-14 08:57:13',NULL,'2014-07-14 08:57:13',NULL),(8,1,8,NULL,'2014-07-14 08:57:13',NULL,'2014-07-14 08:57:13',NULL),(9,1,9,NULL,'2014-07-14 08:57:13',NULL,'2014-07-14 08:57:13',NULL),(10,1,10,NULL,'2014-07-14 08:57:13',NULL,'2014-07-14 08:57:13',NULL),(11,1,11,NULL,'2014-07-14 08:57:13',NULL,'2014-07-14 08:57:13',NULL),(12,1,12,NULL,'2014-07-14 08:57:13',NULL,'2014-07-14 08:57:13',NULL),(13,1,13,NULL,'2014-07-14 08:57:13',NULL,'2014-07-14 08:57:13',NULL),(14,1,14,NULL,'2014-07-14 08:57:13',NULL,'2014-07-14 08:57:13',NULL),(15,1,15,NULL,'2014-07-14 08:57:13',NULL,'2014-07-14 08:57:13',NULL),(24,1,16,NULL,'2014-07-14 08:57:13',NULL,'2014-07-14 08:57:13',NULL),(25,1,17,NULL,'2014-07-14 08:57:13',NULL,'2014-07-14 08:57:13',NULL),(26,1,18,NULL,'2014-07-14 08:57:13',NULL,'2014-07-14 08:57:13',NULL),(27,1,19,NULL,'2014-07-14 08:57:13',NULL,'2014-07-14 08:57:13',NULL),(28,1,20,NULL,'2014-07-14 08:57:13',NULL,'2014-07-14 08:57:13',NULL),(29,1,27,NULL,'2014-07-14 08:57:13',NULL,'2014-07-14 08:57:13',NULL),(30,1,28,NULL,'2014-07-14 08:57:13',NULL,'2014-07-14 08:57:13',NULL),(31,1,29,NULL,'2014-07-14 08:57:13',NULL,'2014-07-14 08:57:13',NULL),(32,1,30,NULL,'2014-07-14 08:57:13',NULL,'2014-07-14 08:57:13',NULL),(33,1,31,NULL,'2014-07-14 08:57:13',NULL,'2014-07-14 08:57:13',NULL),(34,1,32,NULL,'2014-07-14 08:57:13',NULL,'2014-07-14 08:57:13',NULL),(35,1,33,NULL,'2014-07-14 08:57:13',NULL,'2014-07-14 08:57:13',NULL),(36,1,34,NULL,'2014-07-14 08:57:13',NULL,'2014-07-14 08:57:13',NULL),(37,1,35,NULL,'2014-07-14 08:57:13',NULL,'2014-07-14 08:57:13',NULL),(38,1,36,NULL,'2014-07-14 08:57:13',NULL,'2014-07-14 08:57:13',NULL),(39,1,37,NULL,'2014-07-14 08:57:13',NULL,'2014-07-14 08:57:13',NULL),(40,1,38,NULL,'2014-07-14 08:57:13',NULL,'2014-07-14 08:57:13',NULL),(41,1,39,NULL,'2014-07-14 08:57:13',NULL,'2014-07-14 08:57:13',NULL),(42,1,40,NULL,'2014-07-14 08:57:13',NULL,'2014-07-14 08:57:13',NULL),(43,1,42,NULL,'2014-07-14 08:57:13',NULL,'2014-07-14 08:57:13',NULL),(44,1,41,NULL,'2014-07-14 08:57:13',NULL,'2014-07-14 08:57:13',NULL),(68,7,35,1,'2012-08-09 13:55:26',1,'2012-08-09 13:55:26',NULL),(69,7,3,1,'2012-08-09 13:55:26',1,'2012-08-09 13:55:26',NULL),(70,7,36,1,'2012-08-09 13:55:26',1,'2012-08-09 13:55:26',NULL),(71,7,31,1,'2012-08-09 13:55:26',1,'2012-08-09 13:55:26',NULL),(72,7,32,1,'2012-08-09 13:55:26',1,'2012-08-09 13:55:26',NULL),(73,7,33,1,'2012-08-09 13:55:26',1,'2012-08-09 13:55:26',NULL),(74,7,34,1,'2012-08-09 13:55:26',1,'2012-08-09 13:55:26',NULL),(75,4,36,1,'2012-08-10 07:17:40',1,'2012-08-10 07:17:40',NULL),(76,4,32,1,'2012-08-10 07:17:40',1,'2012-08-10 07:17:40',NULL),(77,4,33,1,'2012-08-10 07:17:40',1,'2012-08-10 07:17:40',NULL),(78,2,37,1,'2014-06-30 08:22:52',1,'2014-06-30 08:22:52',NULL),(79,2,12,1,'2014-06-30 08:22:52',1,'2014-06-30 08:22:52',NULL),(80,2,13,1,'2014-06-30 08:22:52',1,'2014-06-30 08:22:52',NULL),(81,2,14,1,'2014-06-30 08:22:52',1,'2014-06-30 08:22:52',NULL),(82,2,15,1,'2014-06-30 08:22:52',1,'2014-06-30 08:22:52',NULL),(83,2,35,1,'2014-06-30 08:22:52',1,'2014-06-30 08:22:52',NULL),(84,2,1,1,'2014-06-30 08:22:52',1,'2014-06-30 08:22:52',NULL),(85,2,2,1,'2014-06-30 08:22:52',1,'2014-06-30 08:22:52',NULL),(86,2,3,1,'2014-06-30 08:22:52',1,'2014-06-30 08:22:52',NULL),(87,2,4,1,'2014-06-30 08:22:52',1,'2014-06-30 08:22:52',NULL),(88,2,8,1,'2014-06-30 08:22:52',1,'2014-06-30 08:22:52',NULL),(89,2,9,1,'2014-06-30 08:22:52',1,'2014-06-30 08:22:52',NULL),(90,2,10,1,'2014-06-30 08:22:52',1,'2014-06-30 08:22:52',NULL),(91,2,11,1,'2014-06-30 08:22:52',1,'2014-06-30 08:22:52',NULL),(92,2,20,1,'2014-06-30 08:22:52',1,'2014-06-30 08:22:52',NULL),(93,2,5,1,'2014-06-30 08:22:52',1,'2014-06-30 08:22:52',NULL),(94,2,6,1,'2014-06-30 08:22:52',1,'2014-06-30 08:22:52',NULL);
/*!40000 ALTER TABLE `trade_rolepermission` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `trade_user`
--

DROP TABLE IF EXISTS `trade_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `trade_user` (
  `UserID` int(11) NOT NULL AUTO_INCREMENT,
  `UserName` varchar(50) DEFAULT NULL,
  `UserPassword` varchar(50) DEFAULT NULL,
  `RoleID` int(11) DEFAULT NULL,
  `DeptID` int(11) DEFAULT NULL,
  `Phone` varchar(13) DEFAULT NULL,
  `Fax` varchar(13) DEFAULT NULL,
  `Email` varchar(100) DEFAULT NULL,
  `QQ` varchar(13) DEFAULT NULL,
  `NickName` varchar(50) DEFAULT NULL,
  `Address` varchar(200) DEFAULT NULL,
  `RealName` varchar(50) DEFAULT NULL,
  `Sex` tinyint(4) DEFAULT NULL,
  `Enabled` tinyint(4) DEFAULT NULL,
  `LastLoginTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `CreateUserID` int(11) DEFAULT NULL,
  `CreateDate` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `ModifyUserID` int(11) DEFAULT NULL,
  `ModifyDate` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `RecordStatus` varchar(200) DEFAULT NULL,
  `IsDeleted` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`UserID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `trade_user`
--

LOCK TABLES `trade_user` WRITE;
/*!40000 ALTER TABLE `trade_user` DISABLE KEYS */;
INSERT INTO `trade_user` VALUES (1,'51aspx','51aspx',NULL,2,'15919592514','',NULL,'409180955','51aspx','','甜甜',1,0,'2014-07-14 08:57:13',NULL,'2014-07-14 08:57:13',1,'2012-08-01 07:57:01',NULL,NULL),(2,'奶奶的','123123',NULL,3,'','',NULL,'','mmd','','nnd',1,0,'2014-07-14 08:57:13',NULL,'2014-07-14 08:57:13',1,'2012-08-01 08:41:55',NULL,NULL),(3,'dd','123123',NULL,3,'12412','',NULL,'','124','','124',1,0,'2014-07-14 08:57:13',NULL,'2014-07-14 08:57:13',1,'2012-08-01 08:26:29',NULL,NULL),(4,'tttttt','123123',NULL,2,'123123','123',NULL,'123','123','123','123123',1,0,'2014-07-14 08:57:13',NULL,'2014-07-14 08:57:13',1,'2012-08-08 12:01:22',NULL,NULL);
/*!40000 ALTER TABLE `trade_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `trade_userrole`
--

DROP TABLE IF EXISTS `trade_userrole`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `trade_userrole` (
  `UserRoleID` int(11) NOT NULL AUTO_INCREMENT,
  `UserID` int(11) DEFAULT NULL,
  `RoleID` int(11) DEFAULT NULL,
  `CreateUserID` int(11) DEFAULT NULL,
  `CreateDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `ModifyUserID` int(11) DEFAULT NULL,
  `ModifyDate` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `RecordStatus` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`UserRoleID`)
) ENGINE=InnoDB AUTO_INCREMENT=54 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `trade_userrole`
--

LOCK TABLES `trade_userrole` WRITE;
/*!40000 ALTER TABLE `trade_userrole` DISABLE KEYS */;
INSERT INTO `trade_userrole` VALUES (3,1,2,NULL,'2014-07-14 08:57:13',NULL,'2014-07-14 08:57:13',NULL),(8,1,1,NULL,'2014-07-14 08:57:13',NULL,'2014-07-14 08:57:13',NULL),(39,2,1,NULL,'2012-08-01 08:41:55',NULL,'2014-07-14 08:57:13',NULL),(50,4,7,NULL,'2012-08-09 13:53:45',NULL,'2014-07-14 08:57:13',NULL),(53,3,4,NULL,'2012-08-10 07:18:01',NULL,'2014-07-14 08:57:13',NULL);
/*!40000 ALTER TABLE `trade_userrole` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary table structure for view `vmodulepermission`
--

DROP TABLE IF EXISTS `vmodulepermission`;
/*!50001 DROP VIEW IF EXISTS `vmodulepermission`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE TABLE `vmodulepermission` (
  `ButtonName` tinyint NOT NULL,
  `ModulePermissionID` tinyint NOT NULL,
  `MenuID` tinyint NOT NULL,
  `ButtonID` tinyint NOT NULL,
  `MenuName` tinyint NOT NULL,
  `MenuUrl` tinyint NOT NULL,
  `ModuleIcon` tinyint NOT NULL,
  `ParentNo` tinyint NOT NULL,
  `Sort` tinyint NOT NULL,
  `IsLeaf` tinyint NOT NULL,
  `IsMenu` tinyint NOT NULL,
  `ModuleController` tinyint NOT NULL,
  `ButtonAction` tinyint NOT NULL,
  `ButtonIcon` tinyint NOT NULL,
  `MenuController` tinyint NOT NULL,
  `modPermissionIsDeleted` tinyint NOT NULL,
  `ParentID` tinyint NOT NULL,
  `Description` tinyint NOT NULL
) ENGINE=MyISAM */;
SET character_set_client = @saved_cs_client;

--
-- Temporary table structure for view `vrolegrantpermission`
--

DROP TABLE IF EXISTS `vrolegrantpermission`;
/*!50001 DROP VIEW IF EXISTS `vrolegrantpermission`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE TABLE `vrolegrantpermission` (
  `PermissionID` tinyint NOT NULL,
  `PermissionAction` tinyint NOT NULL,
  `PermissionName` tinyint NOT NULL,
  `Icon` tinyint NOT NULL,
  `PermissionController` tinyint NOT NULL,
  `Description` tinyint NOT NULL,
  `ParentID` tinyint NOT NULL,
  `ModuleController` tinyint NOT NULL,
  `ModuleName` tinyint NOT NULL,
  `ModuleIcon` tinyint NOT NULL,
  `ModulePermissionID` tinyint NOT NULL
) ENGINE=MyISAM */;
SET character_set_client = @saved_cs_client;

--
-- Temporary table structure for view `vrolemenupermission`
--

DROP TABLE IF EXISTS `vrolemenupermission`;
/*!50001 DROP VIEW IF EXISTS `vrolemenupermission`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE TABLE `vrolemenupermission` (
  `ModuleID` tinyint NOT NULL,
  `ModuleName` tinyint NOT NULL,
  `ModuleLinkUrl` tinyint NOT NULL,
  `ModuleIcon` tinyint NOT NULL,
  `ParentNo` tinyint NOT NULL,
  `Sort` tinyint NOT NULL,
  `IsLeaf` tinyint NOT NULL,
  `IsVisible` tinyint NOT NULL,
  `RoleID` tinyint NOT NULL,
  `ModuleController` tinyint NOT NULL,
  `IsDeleted` tinyint NOT NULL,
  `IsMenu` tinyint NOT NULL
) ENGINE=MyISAM */;
SET character_set_client = @saved_cs_client;

--
-- Temporary table structure for view `vrolemodulepermission`
--

DROP TABLE IF EXISTS `vrolemodulepermission`;
/*!50001 DROP VIEW IF EXISTS `vrolemodulepermission`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE TABLE `vrolemodulepermission` (
  `ModuleID` tinyint NOT NULL,
  `ModuleName` tinyint NOT NULL,
  `ModuleLinkUrl` tinyint NOT NULL,
  `ModuleIcon` tinyint NOT NULL,
  `ParentNo` tinyint NOT NULL,
  `Sort` tinyint NOT NULL,
  `IsVisible` tinyint NOT NULL,
  `IsLeaf` tinyint NOT NULL,
  `IsMenu` tinyint NOT NULL,
  `PermissionName` tinyint NOT NULL,
  `PermissionID` tinyint NOT NULL,
  `RoleID` tinyint NOT NULL,
  `ModuleController` tinyint NOT NULL,
  `PermissionAction` tinyint NOT NULL,
  `Script` tinyint NOT NULL,
  `Icon` tinyint NOT NULL,
  `PermissionController` tinyint NOT NULL,
  `IsButton` tinyint NOT NULL
) ENGINE=MyISAM */;
SET character_set_client = @saved_cs_client;

--
-- Temporary table structure for view `vrolepermission`
--

DROP TABLE IF EXISTS `vrolepermission`;
/*!50001 DROP VIEW IF EXISTS `vrolepermission`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE TABLE `vrolepermission` (
  `ModulePermissionID` tinyint NOT NULL,
  `RoleID` tinyint NOT NULL,
  `RoleName` tinyint NOT NULL,
  `RolePermissionID` tinyint NOT NULL
) ENGINE=MyISAM */;
SET character_set_client = @saved_cs_client;

--
-- Dumping events for database 'tradeproduct'
--

--
-- Dumping routines for database 'tradeproduct'
--
/*!50003 DROP PROCEDURE IF EXISTS `spDeletetrade_Department` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `spDeletetrade_Department`(in myDeptID int)
BEGIN
	declare errorSum int default 0;
	START TRANSACTION;
	delete from trade_Favorite where UserID in (select UserID from trade_User where DeptID=myDeptID);
	set errorSum=errorSum+@@error_count;   -- 累计是否有错误
	delete from trade_UserRole where UserID in (select UserID from trade_User where DeptID=myDeptID);
	set errorSum=errorSum+@@error_count;     -- 累计是否有错误
	delete from trade_User where DeptID=myDeptID;
	set errorSum=errorSum+@@error_count;     -- 累计是否有错误
	delete from trade_Department where DeptID=myDeptID;
	
	if errorSum=0 then
		COMMIT;
	else
		ROLLBACK;
	end if;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `spDeletetrade_Favorite` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `spDeletetrade_Favorite`(IN myFavoriteID int)
BEGIN
	declare errorSum int default 0;
	START TRANSACTION;
	delete from trade_Favorite where FavoriteID=@FavoriteID;
	set errorSum=errorSum+@@error_count ;   -- 累计是否有错误
	if errorSum=0 then
		COMMIT;
	else
		ROLLBACK;
	end if;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `spDeletetrade_Module` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `spDeletetrade_Module`(in myModuleID bigint)
BEGIN
	declare errorSum int default 0;
	START TRANSACTION;
	delete from trade_RolePermission where ModulePermissionID in (select ModulePermissionID from trade_ModulePermission  where ModuleID=myModuleID);
	set errorSum=errorSum+@@error_count ;   -- 累计是否有错误
	delete from trade_ModulePermission where ModuleID=myModuleID;
	set errorSum=errorSum+@@error_count ;   -- 累计是否有错误
	delete from trade_Module where ModuleID=myModuleID;
	set errorSum=errorSum+@@error_count ;   -- 累计是否有错误
	if errorSum=0 then
		COMMIT;
	else
		ROLLBACK;
	end if;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `spDeletetrade_ModulePermission` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `spDeletetrade_ModulePermission`(in myModulePermissionID bigint)
BEGIN
	declare errorSum int default 0;
	START TRANSACTION;
	delete from trade_RolePermission where RoleID in (select RoleID from trade_ModulePermission where ModulePermissionID=myModulePermissionID);
	set errorSum=errorSum+@@error_count ;   -- 累计是否有错误
	delete from trade_ModulePermission where ModulePermissionID=myModulePermissionID;
	set errorSum=errorSum+@@error_count ;   -- 累计是否有错误
	if errorSum=0 then
		COMMIT;
	else
		ROLLBACK;
	end if;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `spDeletetrade_Permission` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `spDeletetrade_Permission`(in myPermissionID bigint)
BEGIN
	declare errorSum int default 0;
	START TRANSACTION;
	delete from trade_RolePermission where ModulePermissionID in (select ModulePermissionID from trade_ModulePermission where PermissionID=myPermissionID);
	set errorSum=errorSum+@@error_count ;   -- 累计是否有错误
	delete from trade_ModulePermission where PermissionID=@PermissionID;
	set errorSum=errorSum+@@error_count ;   -- 累计是否有错误
	delete from trade_Permission where PermissionID=@PermissionID;
	set errorSum=errorSum+@@error_count ;   -- 累计是否有错误
	if errorSum=0 then
		COMMIT;
	else
		ROLLBACK;
	end if;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `spDeletetrade_Role` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `spDeletetrade_Role`(in myRoleID int)
BEGIN
	declare errorSum int default 0;
	START TRANSACTION;
	delete from trade_UserRole where RoleID=myRoleID;
	set errorSum=errorSum+@@error_count ;   -- 累计是否有错误
	delete from trade_RolePermission where RoleID=@RoleID;
	set errorSum=errorSum+@@error_count ;   -- 累计是否有错误
	delete from trade_Role where RoleID=myRoleID;
	set errorSum=errorSum+@@error_count ;   -- 累计是否有错误
	if errorSum=0 then
		COMMIT;
	else
		ROLLBACK;
	end if;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `spDeletetrade_RolePermission` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `spDeletetrade_RolePermission`(in myRolePermissionID bigint)
BEGIN
	declare errorSum int default 0;
	START TRANSACTION;
	delete from trade_RolePermission where RolePermissionID=myRolePermissionID;
	set errorSum=errorSum+@@error_count ;   -- 累计是否有错误
	if errorSum=0 then
		COMMIT;
	else
		ROLLBACK;
	end if;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `spDeletetrade_User` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `spDeletetrade_User`(in myUserID	int)
BEGIN
	declare errorSum int default 0;
	START TRANSACTION;
	delete from trade_Favorite where UserID=myUserID;
	set errorSum=errorSum+@@error_count ;   -- 累计是否有错误
	delete from trade_UserRole where UserID=myUserID;
	set errorSum=errorSum+@@error_count;     -- 累计是否有错误
	delete from trade_User where UserID=myUserID ;
	set errorSum=errorSum+@@error_count ;   -- 累计是否有错误
	if errorSum=0 then
		COMMIT;
	else
		ROLLBACK;
	end if;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `spDeletetrade_UserRole` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `spDeletetrade_UserRole`(in myUserRoleID bigint)
BEGIN
	declare errorSum int default 0;
	START TRANSACTION;
	delete from trade_UserRole where UserRoleID=myUserRoleID;
	set errorSum=errorSum+@@error_count ;   -- 累计是否有错误
	if errorSum=0 then
		COMMIT;
	else
		ROLLBACK;
	end if;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `spPagination` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `spPagination`(myTableName varchar(255), -- 表名
     myInnerJoin varchar(500),  -- inner john连接的表
     mySelectFields varchar(1000), -- 需要返回的列
     myOrderName varchar(255), -- 排序的字段名
     myPageSize int , -- 页尺寸
     myPageIndex int , -- 页码
     myCount bit , -- 返回记录总数, 非0 值则返回
     myOrderType bit , -- 设置排序类型, 非0 值则降序
     myWhereCondition varchar(1500) -- 查询条件(注意: 不要加where
)
BEGIN
	declare strSQL varchar(5000); -- 主语句
	declare strTmp varchar(110); -- 临时变量
	declare strOrder varchar(400); -- 排序类型
	if mySelectFields is null then 
		set mySelectFields='*'; 
	end if;
	if myOrderName is null then 
		set myOrderName='';
	end if;
	if myPageSize is null then 
		set myPageSize=10;
	end if ;
	if myPageIndex is null then 
		set myPageIndex=1;
	end if;
	if myCount is null then 
		set myCount=0;
	end if;
	if myOrderType is null then 
		set myOrderType=0;
	end if;
	if myWhereCondition is null then
		set myWhereCondition='';
	end if;

	if myCount != 0 then

         if myWhereCondition !='' then
             set strSQL = concat(strSQL,'select count(*) as Total from ' , myTableName , ' ',myInnerJoin ,' where ', myWhereCondition );
         else 
             set strSQL = concat(strSQL,'select count(*) as Total from ' , myTableName , ' ',myInnerJoin ,' ') ;
		 end if;
		 -- 以上代码的意思是如果@Count传递过来的不是0，就执行总数统计。以下的所有代码都是@Count为0的情况

	else 
			 if myOrderType != 0 then
					 set strTmp = concat(strTmp,'<(select min' );
					 set strOrder = concat(strOrder,' order by ' , myOrderName ,' desc') ;
					 -- 如果@OrderType不是0，就执行降序，这句很重要！
			 else 
				 set strTmp = concat(strTmp,'>(select max' );
				 set strOrder = concat(strOrder,' order by ' , myOrderName ,' asc') ;
				 if myPageIndex = 1 then 
					 if myWhereCondition != ''  then
						 set strSQL = concat(strSQL,'select top ' , myPageSize ,' ',mySelectFields, ' from `' , myTableName , '` ',myInnerJoin ,' where ' , myWhereCondition , ' ' , mystrOrder );
					 else 
						 set strSQL = concat(strSQL,'select top ' , str(myPageSize) ,' ',mySelectFields+ ' from `', myTableName , '` ',myInnerJoin , strOrder );
						 -- 如果是第一页就执行以上代码，这样会加快执行速度
					 end if;
				 else 
					 
					 -- 以下代码赋予了@strSQL以真正执行的SQL代码
					 set strSQL = concat(strSQL,'select ' , mySelectFields, ' from ' 
						 , myTableName , ' ',myInnerJoin, ' where ' , myOrderName , '' , strTmp , '(', myOrderName , ') from (select top ' , (myPageIndex-1)*myPageSize , ' ', myOrderName + ' from `' , myTableName , '` ',myInnerJoin ,' ' , strOrder , ') as tblTmp)', strOrder ,' limit 0,',myPageSize) ;
						 if myWhereCondition != '' then
							 set strSQL = concat(strSQL,'select ' ,mySelectFields, ' from ' 
								 , myTableName , ' ',myInnerJoin, ' where ' , myOrderName , ' ' , strTmp , '(' 
								 , myOrderName , ' ) from (select top ' , str((myPageIndex-1)*myPageSize) , ' ' 
								 , myOrderName , '  from ' , myTableName , '  ',myInnerJoin ,'  where ' , myWhereCondition , ' ' 
								 , strOrder , ') as tblTmp) and ' , myWhereCondition , ' ' , strOrder,' limit 0,',myPageSize);
						end if;
				end if;
			end if;
	end if;
	select strSQL as mysql;
	/*SET @sql=strSQL;
    PREPARE s1 FROM @sql;
    EXECUTE s1;
    DEALLOCATE PREPARE s1;
	*/
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Final view structure for view `vmodulepermission`
--

/*!50001 DROP TABLE IF EXISTS `vmodulepermission`*/;
/*!50001 DROP VIEW IF EXISTS `vmodulepermission`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `vmodulepermission` AS select `trade_permission`.`PermissionName` AS `ButtonName`,`trade_modulepermission`.`ModulePermissionID` AS `ModulePermissionID`,`trade_modulepermission`.`ModuleID` AS `MenuID`,`trade_modulepermission`.`PermissionID` AS `ButtonID`,`trade_module`.`ModuleName` AS `MenuName`,`trade_module`.`ModuleLinkUrl` AS `MenuUrl`,`trade_module`.`ModuleIcon` AS `ModuleIcon`,`trade_module`.`ParentNo` AS `ParentNo`,`trade_module`.`Sort` AS `Sort`,`trade_module`.`IsLeaf` AS `IsLeaf`,`trade_module`.`IsMenu` AS `IsMenu`,`trade_module`.`ModuleController` AS `ModuleController`,`trade_permission`.`PermissionAction` AS `ButtonAction`,`trade_permission`.`Icon` AS `ButtonIcon`,`trade_permission`.`PermissionController` AS `MenuController`,`trade_modulepermission`.`IsDeleted` AS `modPermissionIsDeleted`,`trade_permission`.`ParentID` AS `ParentID`,`trade_permission`.`Description` AS `Description` from ((`trade_module` join `trade_modulepermission` on((`trade_module`.`ModuleID` = `trade_modulepermission`.`ModuleID`))) join `trade_permission` on((`trade_modulepermission`.`PermissionID` = `trade_permission`.`PermissionID`))) where ((`trade_module`.`IsVisible` = 1) and (`trade_permission`.`IsVisible` = 1)) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `vrolegrantpermission`
--

/*!50001 DROP TABLE IF EXISTS `vrolegrantpermission`*/;
/*!50001 DROP VIEW IF EXISTS `vrolegrantpermission`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `vrolegrantpermission` AS select `trade_permission`.`PermissionID` AS `PermissionID`,`trade_permission`.`PermissionAction` AS `PermissionAction`,`trade_permission`.`PermissionName` AS `PermissionName`,`trade_permission`.`Icon` AS `Icon`,`trade_permission`.`PermissionController` AS `PermissionController`,`trade_permission`.`Description` AS `Description`,`trade_permission`.`ParentID` AS `ParentID`,`trade_module`.`ModuleController` AS `ModuleController`,`trade_module`.`ModuleName` AS `ModuleName`,`trade_module`.`ModuleIcon` AS `ModuleIcon`,`trade_modulepermission`.`ModulePermissionID` AS `ModulePermissionID` from ((`trade_module` join `trade_modulepermission` on((`trade_module`.`ModuleID` = `trade_modulepermission`.`ModuleID`))) join `trade_permission` on((`trade_modulepermission`.`PermissionID` = `trade_permission`.`PermissionID`))) where ((`trade_module`.`IsDeleted` = 0) and (`trade_modulepermission`.`IsDeleted` = 0)) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `vrolemenupermission`
--

/*!50001 DROP TABLE IF EXISTS `vrolemenupermission`*/;
/*!50001 DROP VIEW IF EXISTS `vrolemenupermission`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `vrolemenupermission` AS select distinct `trade_module`.`ModuleID` AS `ModuleID`,`trade_module`.`ModuleName` AS `ModuleName`,`trade_module`.`ModuleLinkUrl` AS `ModuleLinkUrl`,`trade_module`.`ModuleIcon` AS `ModuleIcon`,`trade_module`.`ParentNo` AS `ParentNo`,`trade_module`.`Sort` AS `Sort`,`trade_module`.`IsLeaf` AS `IsLeaf`,`trade_module`.`IsVisible` AS `IsVisible`,`trade_rolepermission`.`RoleID` AS `RoleID`,`trade_module`.`ModuleController` AS `ModuleController`,`trade_module`.`IsDeleted` AS `IsDeleted`,`trade_module`.`IsMenu` AS `IsMenu` from (`trade_module` left join (`trade_rolepermission` join `trade_modulepermission` on((`trade_rolepermission`.`ModulePermissionID` = `trade_modulepermission`.`ModulePermissionID`))) on((`trade_modulepermission`.`ModuleID` = `trade_module`.`ModuleID`))) where ((`trade_module`.`IsVisible` = 1) and (`trade_module`.`IsMenu` = 1)) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `vrolemodulepermission`
--

/*!50001 DROP TABLE IF EXISTS `vrolemodulepermission`*/;
/*!50001 DROP VIEW IF EXISTS `vrolemodulepermission`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `vrolemodulepermission` AS select `trade_module`.`ModuleID` AS `ModuleID`,`trade_module`.`ModuleName` AS `ModuleName`,`trade_module`.`ModuleLinkUrl` AS `ModuleLinkUrl`,`trade_module`.`ModuleIcon` AS `ModuleIcon`,`trade_module`.`ParentNo` AS `ParentNo`,`trade_module`.`Sort` AS `Sort`,`trade_module`.`IsVisible` AS `IsVisible`,`trade_module`.`IsLeaf` AS `IsLeaf`,`trade_module`.`IsMenu` AS `IsMenu`,`trade_permission`.`PermissionName` AS `PermissionName`,`trade_permission`.`PermissionID` AS `PermissionID`,`trade_rolepermission`.`RoleID` AS `RoleID`,`trade_module`.`ModuleController` AS `ModuleController`,`trade_permission`.`PermissionAction` AS `PermissionAction`,`trade_permission`.`Script` AS `Script`,`trade_permission`.`Icon` AS `Icon`,`trade_permission`.`PermissionController` AS `PermissionController`,`trade_permission`.`IsButton` AS `IsButton` from (((`trade_module` join `trade_modulepermission` on((`trade_module`.`ModuleID` = `trade_modulepermission`.`ModuleID`))) join `trade_permission` on((`trade_modulepermission`.`PermissionID` = `trade_permission`.`PermissionID`))) join `trade_rolepermission` on((`trade_modulepermission`.`ModulePermissionID` = `trade_rolepermission`.`ModulePermissionID`))) where ((`trade_permission`.`IsVisible` = 1) and (`trade_module`.`IsVisible` = 1)) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `vrolepermission`
--

/*!50001 DROP TABLE IF EXISTS `vrolepermission`*/;
/*!50001 DROP VIEW IF EXISTS `vrolepermission`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `vrolepermission` AS select `trade_rolepermission`.`ModulePermissionID` AS `ModulePermissionID`,`trade_rolepermission`.`RoleID` AS `RoleID`,`trade_role`.`RoleName` AS `RoleName`,`trade_rolepermission`.`RolePermissionID` AS `RolePermissionID` from (`trade_role` join `trade_rolepermission` on((`trade_role`.`RoleID` = `trade_rolepermission`.`RoleID`))) where (`trade_role`.`IsVisible` = 1) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2014-08-20 10:00:47
