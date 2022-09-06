const routeId = document.getElementById('routeId').value

const commentCtnr = document.getElementById('commentCtnr')

const allComments = []

const displayComments = (comments) => {
    commentCtnr.innerText = comments.map(
        (c) => {
            return asComment(c)
        }
    ).join('')
}

function asComment(c) {
    let commentHtml = '<div id="commentCntr-${c.commentId}">'

    commentHtml += '<h4>${c.user} (${c.created})</h4>'
    commentHtml += '<p>${c.textContent}</p>'
    commentHtml += '</div>'
    return commentHtml
}

fetch('http://localhost:8000/api/${routeId}/comments')
    .then(response => response.json())
    .then(data => {
            for (let comment of data) {
                allComments.push(data)
            }
        } displayComments(allComments)
    )