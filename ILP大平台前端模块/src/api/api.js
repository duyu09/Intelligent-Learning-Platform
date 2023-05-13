import axios from "axios";
import Cookies from 'js-cookie';
import { errHandle } from "../utils/tools";
const baseURL='http://alpha.ilp.technology:8080';
export
{
    showItem,getToken,setToken,loginVerification,getAvatar,getUserInformation,showFile,
    setUserInformation,updataInformation,setAvatar,addFlag,showFlag,deleteFlag,upload,downloadFile,
    showOrg,deleteOrg,creatForum,releaseItem,showForum,showPsy,deleteItem,signIn,createOrg,
    readStudyStatus,readStudyRoom,readSignInContext,startStudy,dredgePsy,upvote,skillTest,getMusicList,
}

// 写入token到cookie,成功返回0，失败返回1.
function setToken(token)
{
    if(token==undefined)
    {
        errHandle("身份验证出现了错误。");
        return 1;
    }
    else
    {
        Cookies.set("token",token);
        return 0;
    }
}

// 从cookie里读取token,成功返回token,失败弹窗，并跳转至登录页。
function getToken()
{
    const token=Cookies.get("token");
    if(token==undefined)
    {
        errHandle("您尚未登录或您的登录状态已过期。");
        setTimeout(()=>{},1500);
        //跳转至登录页面。
        return undefined;
    }
    else return token;
}

//01.登录验证
function loginVerification(userId,passWord)
{
    return axios.post(baseURL+'/loginVerification',{
        'userId':userId,
        'passWord':passWord
    })
}

//02.获取用户头像
function getAvatar(userId,aimUserId)
{
    return axios.post(baseURL+'/getAvatar',{
        'userId':userId,
        'aimUserId':aimUserId
    },{headers:{'Authorization':getToken()}})

}

//03.获取用户基本信息
function getUserInformation(userId,aimUserId) {
    return axios.post(baseURL+'/getUserInformation',{
        'userId':userId,
        'aimUserId':aimUserId
    },{headers:{'Authorization':getToken()}});
}

//04.注册用户基本信息
function setUserInformation(userName,userNickname,userSex,userSchool,userMajor,userSelfIntroduction,userPassword,userAvatar) {
    return axios.post(baseURL+'/setUserInformation',{
        "userName": userName,
        "userNickname": userNickname,
        "userSex": userSex,
        "userSchool": userSchool,
        "userMajor": userMajor,
        "userSelfIntroduction": userSelfIntroduction,
        "userPassword": userPassword,
        "userAvatar": userAvatar,
        "userRegisterTime": Date.now()
    });
    
}

//04-02.修改用户的基本信息
function updataInformation(userId,userName,userNickname,userSex,userSchool,userMajor,userSelfIntroduction,userPassword)
{
    return axios.post(baseURL+'/updataInformation',{
        "userId":userId,
        "userName": userName,
        "userNickname": userNickname,
        "userSex": userSex,
        "userSchool": userSchool,
        "userMajor": userMajor,
        "userSelfIntroduction": userSelfIntroduction,
        "userPassword": userPassword
    },{headers:{'Authorization':getToken()}});
}

//05.设置用户头像
function setAvatar(userId,imgData) {
    return axios.post(baseURL+'/setAvatar',{
        "userId":userId,
        "imgData":imgData
    },{headers:{'Authorization':getToken()}})
}

//06.联系客服
// function f() {
//
// }

//07.技术能力检测模块
// function f() {
//
// }

//08.添加目标
function addFlag(userId,context) {
    return axios.post(baseURL+'/addFlag',{
        "userId":userId,
        "context":context
    },{headers:{'Authorization':getToken()}})
}

//09.展示目标
function showFlag(userId,aimUserId)
{
    return axios.post(baseURL+'/showFlag',{
        'userId':userId,
        'aimUserId':aimUserId
    },{headers:{'Authorization':getToken()}})
}

//10.删除目标
function deleteFlag(userId,id)
{
    return axios.post(baseURL+'/deleteFlag',{
        'userId':userId,
        'id':id
    },{headers:{'Authorization':getToken()}})
}

//11.12.13

//14.学生组织列表
function showOrg(userId)
{
    return axios.post(baseURL+'/showOrg',{
        'userId':userId
    },{headers:{'Authorization':getToken()}})
}

//15.删除组织
function deleteOrg(userId,Id)
{
    return axios.post(baseURL+'/deleteOrg',{
        'userId':userId,
        'Id':Id
    },{headers:{'Authorization':getToken()}})
}

//16.创建论坛
function creatForum(userId,name,attrib)
{
    return axios.post(baseURL+'/creatForum',{
        'userId':userId,
        'name':name,
        'attrib':attrib
    },{headers:{'Authorization':getToken()}});
}

//16-02.创建组织
function createOrg(userId,orgAttrib,orgName,orgDescription,orgRecruitment)
{
    return axios.post(baseURL+'/creatOrg',{
        'userId':userId,
        "orgAttrib": orgAttrib,
        "orgName": orgName,
        "orgDescription": orgDescription,
        "orgRecruitment":orgRecruitment,
        "orgAddTime":Date.now()
    },{headers:{'Authorization':getToken()}});
}

//17.发布帖子或纳新信息
function releaseItem(userId,forumId,context)
{
    return axios.post(baseURL+'/releaseItem',{
        'userId':userId,
        'forumId':forumId,
        'context':context,
    },{headers:{'Authorization':getToken()}})
}

//18.展示论坛列表
function showForum(userId)
{
    return axios.post(baseURL+'/showForum',{
        'userId':userId
    },{headers:{'Authorization':getToken()}})
}

//19.帖子与纳新项目表
function showItem(forumId)
{
    return axios.post(baseURL+'/showItem',{
        "forumId":forumId,
    },{headers:{'Authorization':getToken()}})
}

//20.删除帖子或纳新信息
function deleteItem(userId,Id)
{
    return axios.post(baseURL+'/deleteItem',{
        'userId':userId,
        'Id':Id
    },{headers:{'Authorization':getToken()}})
}

//21.心理焦虑疏导模块
// function () {
//
// }

//22.心理疏导使用记录
function showPsy(userId)
{
    return axios.post(baseURL+'/showPsy',{
        'userId':userId
    },{headers:{'Authorization':getToken()}})
}

//23.略

//24.用户签到
function signIn(userId,context)
{
    return axios.post(baseURL+'/signIn',{
        'userId':userId,
        'context':context
    },{headers:{'Authorization':getToken()}})
}

//25.读取签到状态
function readSignInContext(userId)
{
    return axios.post(baseURL+'/readSignInContext',{
        'userId':userId
    },{headers:{'Authorization':getToken()}})
}

//26.读取自习楼状况
function readStudyRoom(userId,floor)
{
    axios.post(baseURL+'/readStudyRoom',{
        'userId':userId,
        'floor':floor
    },{headers:{'Authorization':getToken()}})
}

//27.开始自习
function startStudy(floor,site,startTime,context,encourage,length)
{
    return axios.post(baseURL+'/startStudy',{
        "floor": floor,
        "site": site,
        "startTime": startTime,
        "context": context,
        "encourage": encourage,
        "length": length
    },{headers:{'Authorization':getToken()}})
}

//28.读取自习状态或强制结束自习
function readStudyStatus(userId,operation)
{
    return axios.post(baseURL+'/readStudyStatus',{
        "userId":userId,
        "operation":operation
    },{headers:{'Authorization':getToken()}});
}

//psy小智同学机器人
function dredgePsy(userId,inputContext)
{
    return axios.post(baseURL+'/dredgePsy',{
        "inputContext":inputContext
    },{headers:{'Authorization':getToken()}});
}

//技术与能力检测模块
function skillTest(userId,workMode,expectSalary,expectCity,expectJob,inputContext)
{
    return axios.post(baseURL+'/skillTest',{
        "userId":userId,
        "workMode":workMode,
        "expectSalary":expectSalary,
        "expectCity":expectCity,
        "expectJob":expectJob,
        "inputContext":inputContext
    },{headers:{'Authorization':getToken()}});
}

//评论点赞
function upvote(userId,id)
{
    return axios.post(baseURL+'/upvote',{
        "userId":userId,
        "id":id
    },{headers:{'Authorization':getToken()}})
}

//上传资源
function upload(formData)
{
    return axios.post(baseURL+'/upload',formData,
        {headers:{'Authorization':getToken(),'content-type':'multipart/form-data'}});
}

//获取资源列表
function showFile(userId)
{
    return axios.post(baseURL+'/showFile',{
        "userId":userId
    },{headers:{'Authorization':getToken()}});

}

//下载资源
function downloadFile(id)
{
    window.location=baseURL+'/download?id='+id;
}

//从AutumnFish获取音乐信息JSON
function getMusicList(context)
{
    return axios.get('https://autumnfish.cn/search?keywords='+context);
}