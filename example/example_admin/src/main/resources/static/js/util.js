/**
 * @Description 获取数据
 * @param null
 * @return 数据
 * @author zouyuxiao
 * @date 2020-09-30 10:08
 */
function getData(url) {
    let data;
    $.ajax({
        url: url,
        type:"get",
        async:false,
        success:function (result) {
            data = result;
        },
        error:function (error) {
            data = error;
        }
    })
    return data;
}

function analysisView(data) {
    var viewStr=" ";
    $.each(data,function(index,value){
        viewStr += "<tr><td>"+value+"</td><td><a href='javascript:void(0);' onclick='download()'>下载</a></td></tr>"
    });
    return viewStr;
}

function postData(url,data) {
    let dataResult;
    console.log("data--"+data+"--"+url)
    $.ajax({
        url: url,
        type:"get",
        data:data,
        async:false,
        success:function (result) {
            dataResult = result;
        },
        error:function (error) {
            dataResult = error;
        }
    })
    console.log("dataResult--"+dataResult)
    return dataResult;
}

// 将反斜杠转换成斜杠：
function slash(url) {
    url = url .replace("\\\\", "\/\/");
    url = url .replace("\\", "\/");
    url = url .replace("\\", "\/");
    return url;
}

//将斜杠转换成反斜杠：
function backslash(url) {
    url = url .replace("\/\/", "\\\\");
    url = url .replace("\/", "\\");
    url = url .replace("\/", "\\");
    return url;
}