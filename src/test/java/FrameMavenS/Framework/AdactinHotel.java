package FrameMavenS.Framework;

import java.io.IOException;

import org.openqa.selenium.WebElement;

public class AdactinHotel {

	public static void main(String[] args) throws InterruptedException, IOException{
		// TODO Auto-generated method stub
		BaseClass b = new BaseClass();
		b.browserConfigChrome();
		b.OpenUrl("https://adactinhotelapp.com/");
		b.maximizeWindow();
		WebElement txtUsername = b.locatedById("username");
		String username = b.readNewData("DataBase", 0, 1);
		b.textInput(txtUsername, username);
		WebElement txtPassword = b.locatedById("password");
		String password = b.readNewData("DataBase", 1, 1);
		b.textInput(txtPassword, password);
		WebElement BtnLogin = b.locatedById("login");
		b.click(BtnLogin);
		WebElement DdnLocation = b.locatedById("location");
		b.ddnByIndex(DdnLocation, 5);
		WebElement DdnHotel = b.locatedById("hotels");
		b.ddnByIndex(DdnHotel, 2);
		WebElement DdnRoom = b.locatedById("room_type");
		b.ddnByIndex(DdnRoom, 2);
		WebElement DdnNoRoom = b.locatedById("room_nos");
		b.ddnByIndex(DdnNoRoom, 2);
		WebElement ChInDate = b.locatedById("datepick_in");
		String ChkIn = b.readNewData("DataBase", 7, 1);
		b.textInput(ChInDate, ChkIn);
		WebElement ChOutDate = b.locatedById("datepick_in");
		String ChkOut = b.readNewData("DataBase", 8, 1);
		b.textInput(ChOutDate, ChkOut);
		WebElement DdnadtRoom = b.locatedById("adult_room");
		b.ddnByIndex(DdnadtRoom, 2);
		WebElement DdnChdRoom = b.locatedById("child_room");
		b.ddnByIndex(DdnChdRoom, 2);
		WebElement BtnSearch = b.locatedById("Submit");
		b.click(BtnSearch);
		WebElement RdoBtnSelect = b.locatedById("radiobutton_0");
		b.click(RdoBtnSelect);
		WebElement BtnContinue = b.locatedById("continue");
		b.click(BtnContinue);
		WebElement txtFirstName = b.locatedById("first_name");
		String firstname = b.readNewData("DataBase", 2, 1);
		b.textInput(txtFirstName, firstname);
		WebElement txtLastName = b.locatedById("last_name");
		String lastname = b.readNewData("DataBase", 3, 1);
		b.textInput(txtLastName, lastname);
		WebElement txtAddress = b.locatedById("address");
		String address = b.readNewData("DataBase", 4, 1);
		b.textInput(txtAddress, address);
		WebElement txtCCNo = b.locatedById("cc_num");
		String CCNo = b.readNewData("DataBase", 5, 1);
		b.textInput(txtCCNo, CCNo);
		WebElement DdnCCType = b.locatedById("cc_type");
		b.ddnByIndex(DdnCCType, 2);
		WebElement DdnExpMon = b.locatedById("cc_exp_month");
		b.ddnByIndex(DdnExpMon, 7);
		WebElement DdnExpDate = b.locatedById("cc_exp_year");
		b.ddnByIndex(DdnExpDate, 10);
		WebElement txtCVVNo = b.locatedById("cc_cvv");
		String CVVNo = b.readNewData("DataBase", 6, 1);
		b.textInput(txtCVVNo, CVVNo);
		WebElement BtnBookNow = b.locatedById("book_now");
		b.click(BtnBookNow);
		b.sleep(10000);
		WebElement OrderNo = b.locatedById("order_no");
		String text = OrderNo.getAttribute("value");
		b.insertNewValue("DataBase", 9, 1, text);
		System.out.println(text);

	}
}
