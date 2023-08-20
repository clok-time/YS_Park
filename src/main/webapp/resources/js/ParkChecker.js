/**
 * ParkChecker.js
 * 
 */

function joinCheck() {
	var idInput = document.joinForm.p_id;
	var pwInput = document.joinForm.p_pw;
	var pwChkInput = document.joinForm.p_pwChk;
	var nameInput = document.joinForm.p_name;
	var addr1Input = document.joinForm.p_addr1;
	var addr2Input = document.joinForm.p_addr2;
	var addr3Input = document.joinForm.p_addr3;
	var photoInput = document.joinForm.p_photo;

	if (isEmpty(idInput) || atLeastLetter(idInput, 4)) {
		alert("ID를 다시 입력해주세요.");
		idInput.value = "";
		idInput.focus();
		return false;
	} else if (isEmpty(pwInput) || atLeastLetter(pwInput, 4)) {
		alert("PW를 다시 입력해주세요.")
		pwInput.value = "";
		pwInput.focus();
		return false;
	} else if (isEmpty(pwChkInput) || atLeastLetter(pwChkInput, 4)
			|| notEqualPw(pwChkInput, pwInput)) {
		alert("입력하신 PW와 다릅니다.")
		pwChkInput.value = "";
		pwChkInput.focus();
		return false;
	} else if (isEmpty(nameInput) || atLeastLetter(nameInput, 4)) {
		alert("이름을 다시 입력해주세요.")
		nameInput.value = "";
		nameInput.focus();
		return false;
	} else if (isEmpty(addr1Input) || isEmpty(addr2Input)
			|| isEmpty(addr3Input)) {
		alert("주소를 다시 입력해수세요")
		addr1Input.value = "";
		addr2Input.value = "";
		addr3Input.value = "";
		addr3Input.focus();
		return false;
	} else if (isEmpty(photoInput) || isNotType(photoInput, "jpg")
			&& (isNotType(photoInput, "gif"))
			&& (isNotType(photoInput, "jfif"))
			&& (isNotType(photoInput, "png")) && (isNotType(photoInput, "GIF"))
			&& (isNotType(photoInput, "jpeg"))
			&& (isNotType(photoInput, "JPEG"))
			&& (isNotType(photoInput, "jpg"))) {

		alert('사진을 다시 선택해주세요.');
		photoInput.value = "";
		photoInput.focus();
		return false;
	}
	return true;

}

function memberUpdateCheck() {
	var pwInput = document.memberUpdateForm.p_pw;
	var pwChkInput = document.memberUpdateForm.p_pwChk;
	var nameInput = document.memberUpdateForm.p_name;
	var addr1Input = document.memberUpdateForm.p_addr1;
	var addr2Input = document.memberUpdateForm.p_addr2;
	var addr3Input = document.memberUpdateForm.p_addr3;
	var photoInput = document.memberUpdateForm.p_photo;

	if (isEmpty(pwInput) || notContain(pwInput, "1234567890")) {
		alert("비밀번호를 다시 입력해주세요.");
		pwInput.value = "";
		pwInput.focus();
		return false;
	} else if (isEmpty(nameInput)) {
		alert("이름을 다시 입력해주세요.");
		nameInput.value = "";
		nameInput.focus();
		return false;
	} else if (isEmpty(addr1Input) || isEmpty(addr2Input)
			|| isEmpty(addr3Input)) {
		alert("주소를 바르게 입력해주세요.");
		addr1Input.value = "";
		addr2Input.value = "";
		addr3Input.value = "";
		addr3Input.focus();
		return false;
	} else if (isEmpty(pwChkInput) || atLeastLetter(pwChkInput, 4)
			|| notEqualPw(pwChkInput, pwInput)) {
		alert("입력하신 PW와 다릅니다.")
		pwChkInput.value = "";
		pwChkInput.focus();
		return false;

	}else if (isEmpty(photoInput)) {
		return true;
	}
	else if (isNotType(photoInput, "png") && isNotType(photoInput, "gif")
			&& isNotType(photoInput, "jpg") && isNotType(photoInput, "jpeg")
			&& isNotType(photoInput, "bmp") && isNotType(photoInput, "PNG")
			&& isNotType(photoInput, "GIF") && isNotType(photoInput, "JPG")
			&& isNotType(photoInput, "JPEG") && isNotType(photoInput, "BMP")
			&& isNotType(photoInput, "jfif")) {
		alert("사진 파일을 확인해주세요.");
		photoInput.value = "";
		photoInput.focus();
		return false;
	}
	return true;
}

