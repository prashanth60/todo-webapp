$("#editModal").on("show.bs.modal", function (event) {
  var button = $(event.relatedTarget); // Button that triggered the modal

  var id = button.data("id"); // Extract info from data-* attributes
  var content = button.data("content");
  var completed = button.data("completed");
  var modal = $(this);

  modal.find("#itemCompletedEdit").prop("checked", completed);
  modal.find("#itemContentEdit").val(content);
  modal.find("#itemIdEdit").val(id);
});

$("#deleteModal").on("show.bs.modal", function (event) {
  var button = $(event.relatedTarget); // Button that triggered the modal

  var id = button.data("id"); // Extract info from data-* attributes
  var content = button.data("content");
  var modal = $(this);

  modal.find("#itemIdDelete").val(id);
  modal.find("#itemContentDelete").text(content);

});