package com.qa.opencart.utils;

import java.util.Arrays;
import java.util.List;

public class Constants {
	public static final String LOGIN_PAGE_TITLE = "Login Page";
	public static final String ACCOUNT_PAGE_TITLE = "My Account";
	public static final String ACCOUNTS_PAGE_HEADER = "Your Store";
	public static final String REGISTRATION_SUCCSESSFUL = "Your Account Has Been Created!";
	public static final String REGISTER_SHEET_NAME = "Register";
	public static final int IMAC_IMAGE_COUNT = 3;

	public static final String ACCOUNT_NAVIGATION_SHEET_NAME = "NavigationLinks";

	public static List<String> getExpectedAccountSectionList() {

		return Arrays.asList("My Account", "My Orders", "My Affiliate Account", "Newsletter");

	}

	public static List<String> getExpectedMenuList() {
		return Arrays.asList("Desktops", "Laptops & Notebooks", "Components", "Tablets", "Software", "Phones & PDAs",
				"Cameras", "MP3 Players");
	}

	public static List<String> getExpecetedNavigationLinkAccountPage() {
		return Arrays.asList("My Account", "Edit Account", "Password", "Address Book", "Wish", "ListOrder", " History",
				"Downloads", "Recurring payments", "Reward Points", "Returns", "Transactions", "Newsletter", "Logout");
	}

}
