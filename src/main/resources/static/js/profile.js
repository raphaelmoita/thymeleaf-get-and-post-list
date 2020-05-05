$('.add').click(function(e) {
    e.preventDefault();

    var link = '<tr>' +
               '   <td>' +
               '      <input id="links' + id + '.description" name="links[' + id + '].description" value="link-' + id + '">' +
               '   </td>' +
               '   <td>' +
               '      <input id="links' + id + '.url" name="links[' + id + '].url">' +
               '   </td>' +
               '   <td>' +
               '      <input type="button" id="delete" value="delete">' +
               '   </td>' +
               '</tr>';

    $('.myTable').append(link);
    id++;
});

$(".save").click(function(e) {
    e.preventDefault();
    $(".form").submit();
});

$(".cancel").click(function() {
    console.log('cancel');
    document.location.replace('/');
});

$('.myTable').on('click', 'input[id=delete]', function (e) {
    e.preventDefault();
    $(this).closest('tr').remove();
})