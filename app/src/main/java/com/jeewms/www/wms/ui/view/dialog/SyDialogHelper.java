package com.jeewms.www.wms.ui.view.dialog;

import android.content.Context;

import com.jeewms.www.wms.ui.view.dialog.SyMessageDialog.OnClickListener;

public class SyDialogHelper {

	private static SyMessageDialog showMessageDialog(Context context, int type, String title, String msg, String btn, OnClickListener click) {
		SyMessageDialog dlg = new SyMessageDialog(context, type)
			.setTitleText(title)
			.setMessageText(msg)
			.setPositiveButton(btn, click);
		dlg.show();
		return dlg;
	}
	private static SyMessageDialog showMessageDialog(Context context, int type, String title, String msg, String btn, String btnCancle, OnClickListener click) {
		SyMessageDialog dlg = new SyMessageDialog(context, type)
				.setTitleText(title)
				.setMessageText(msg)
				.setPositiveButton(btn, click)
				.setNegativeButton(btnCancle);
		dlg.show();
		return dlg;
	}
	private static SyMessageDialog showMessageDialog(Context context, int type, String title, String msg, String btnOk, String btnCancle, OnClickListener click,
                                                     OnClickListener cancle) {
		SyMessageDialog dlg = new SyMessageDialog(context, type)
				.setTitleText(title)
				.setMessageText(msg)
				.setLinearButton(btnOk, click)
				.setNegativeButton(btnCancle,cancle);
		dlg.show();
		return dlg;
	}
	private static SyMessageDialog showMessageDialog(Context context, int type, String title, String msg, String btn, OnClickListener click, boolean IsCancleable) {
		SyMessageDialog dlg = new SyMessageDialog(context, type,IsCancleable)
				.setTitleText(title)
				.setMessageText(msg)
				.setPositiveButton(btn, click);
		dlg.show();
		return dlg;
	}
	public static SyMessageDialog showDlg(Context context, String title, String msg, String btn) {
		return showMessageDialog(context, SyMessageDialog.TYPE_NORMAL, title, msg, btn, null);
	}
	public static SyMessageDialog showDlg(Context context, String title, String msg, String btn, boolean IsCancleable) {
		return showMessageDialog(context, SyMessageDialog.TYPE_NORMAL, title, msg, btn, null);
	}
	public static SyMessageDialog showDlg(Context context, String title, String msg, String btn, OnClickListener click) {
		return showMessageDialog(context, SyMessageDialog.TYPE_NORMAL, title, msg, btn, click);
	}
	public static SyMessageDialog showDlg(Context context, String title, String msg, String btn, String btnCanle, OnClickListener click) {
		return showMessageDialog(context, SyMessageDialog.TYPE_NORMAL, title, msg, btn, btnCanle,click);
	}
	public static SyMessageDialog showDlg(Context context, String title, String msg, String btn, OnClickListener click, boolean falg) {
		return showMessageDialog(context, SyMessageDialog.TYPE_NORMAL, title, msg, btn, click);
	}
	public static SyMessageDialog showInfoDlg(Context context, String title, String msg, String btn) {
		return showMessageDialog(context, SyMessageDialog.TYPE_INFORMATION, title, msg, btn, null);
	}
	
	public static SyMessageDialog showSuccessDlg(Context context, String title, String msg, String btn) {
		return showMessageDialog(context, SyMessageDialog.TYPE_SUCCESS, title, msg, btn, null);
	}
	public static SyMessageDialog showErrorDlg(Context context, String title, String msg, String btn, OnClickListener click) {
		return showMessageDialog(context, SyMessageDialog.TYPE_ERROR, title, msg, btn, click);
	}
	
	public static SyMessageDialog showErrorDlg(Context context, String title, String msg, String btn) {
		return showMessageDialog(context, SyMessageDialog.TYPE_ERROR, title, msg, btn, null);
	}
	
	public static SyMessageDialog showWarningDlg(Context context, String title, String msg, String btn) {
		return showMessageDialog(context, SyMessageDialog.TYPE_WARNING, title, msg, btn, null);
	}
	
	public static SyMessageDialog showLoadingDlg(Context context, String title) {
		return showMessageDialog(context, SyMessageDialog.TYPE_LOADING, title, null, null, null);
	}
	
	public static void showAlertDlg(Context context, String msg) {
		showAlertDlg( context,msg, null);
	}

	public static void showAlertDlg(Context context, String title, String msg) {
		SyDialogHelper.showWarningDlg(context, title, msg, "知道了");
	}
	public static SyMessageDialog showDlgLinear(Context context, String title, String msg, String btnOk, String btnCancle , OnClickListener click, OnClickListener cancle) {
		return showMessageDialog(context, SyMessageDialog.TYPE_NORMAL, title, msg, btnOk,btnCancle, click,cancle);
	}
	public static void dissmiss(){

	}
}
