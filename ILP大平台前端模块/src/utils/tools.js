import { ElNotification } from "element-plus";
import { ElMessage, ElMessageBox } from 'element-plus';

export
{
    convertTime,errHandle,msgHandle,successHandle,
    convertTimeChinese,
}


function convertTime(unixTime)
{
    const date = new Date(unixTime);
    const year = date.getFullYear();
    const month = date.getMonth() + 1;
    const day = date.getDate();
    const hours = date.getHours();
    const minutes = date.getMinutes();
    const seconds = date.getSeconds();
    // const ms = date.getMilliseconds();
    function pad(number, length = 2)
    {
        return String(number).padStart(length, '0');
    }
    return `${year}-${pad(month)}-${pad(day)} ${pad(hours)}:${pad(minutes)}:${pad(seconds)}`;
}


function errHandle(describe)
{
    ElNotification({
        title: '警告',
        message: describe,
        type: 'warning',
    });
}

function msgHandle(describe)
{
    return ElMessageBox.alert(describe, '系统提示', {
        confirmButtonText: '确定'
    });
}

function successHandle(describe)
{
    ElNotification({
        title: '成功',
        message: describe,
        type: 'success',
    });
}

function convertTimeChinese(unixTime)
{
    const date = new Date(unixTime);
    const year = date.getFullYear();
    const month = date.getMonth() + 1;
    const day = date.getDate();
    const hours = date.getHours();
    const minutes = date.getMinutes();
    const seconds = date.getSeconds();
    // const ms = date.getMilliseconds();
    function pad(number, length = 2)
    {
        return String(number).padStart(length, '0');
    }
    return `${year}年${pad(month)}月${pad(day)}日 ${pad(hours)}时${pad(minutes)}分${pad(seconds)}秒`;
}