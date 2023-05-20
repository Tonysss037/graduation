const title = '"嗨约"——江苏海洋大学校园运动信息系统'

export default function getPageTitle(pageTitle) {
    if (pageTitle) {
        return `${pageTitle}`
    }
    return `${title}`
}