do_format_time()

function do_format_time() {
	AllDateTime = document.getElementsByClassName("date-time-format")
	for (let time of AllDateTime) {
		// Lấy nội dung text của mỗi đối tượng
		var textValue = time.innerText;
		// Chuyển đổi text thành đối tượng Date
		var dateObject = new Date(textValue);
		var now = new Date();
		var timeDifference = now.getTime() - dateObject.getTime();
		var minutesDifference = Math.floor(timeDifference / (1000 * 60));

		if (minutesDifference < 60) {
			time.innerText = ' '+minutesDifference + (minutesDifference === 1 ? ' min ago' : ' mins ago');
		} else if (minutesDifference < 1440) {
			var hoursDifference = Math.round(minutesDifference / 60);
			time.innerText = ' '+ hoursDifference + (hoursDifference === 1 ? ' hour ago' : ' hours ago');
		}
		else if (!isNaN(dateObject.getTime())) {
			// Chuyển đổi thành công, bạn có thể làm gì đó với đối tượng Date ở đây
			var formattedDate = new Intl.DateTimeFormat('en-US', {
				year: 'numeric',
				month: 'numeric',
				day: 'numeric',
				hour: 'numeric',
				minute: 'numeric',
				second: 'numeric',
				timeZone: 'Asia/Bangkok' // Điều chỉnh múi giờ theo cần thiết
			}).format(dateObject);

			// Gán lại giá trị text đã được định dạng trở lại cho đối tượng
			time.innerText = formattedDate;
		} else {
			// Xử lý trường hợp không thể chuyển đổi thành công
		}
	}
}