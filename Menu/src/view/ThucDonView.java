package view;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import control.ThucDonController;
import model.ThucDonModel;

public class ThucDonView extends JFrame{
	public ThucDonModel thucDonModel;
	public JLabel jLabel_ThongTin;
	public JList<String> list_buttonGroup_MonPhu;
	public JComboBox<String> jComBoBox_monanchinh;


	public ThucDonView() {
		this.thucDonModel = new ThucDonModel();
		init();
	}

	private void init() {
		this.setSize(600, 600);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());

		Font font = new Font("Arial", Font.BOLD, 40);

		JLabel header = new JLabel("THỰC ĐƠN NHÀ HÀNG ");
		header.setFont(font);

		JPanel jPanel_TieuDe = new JPanel();
		jPanel_TieuDe.add(header);
		this.add(jPanel_TieuDe, BorderLayout.NORTH);

		JPanel jPanel_MonChinh = new JPanel();
		jPanel_MonChinh.setLayout(new GridLayout());
		String[] MonAnChinh = new String[] {"CƠM","BÁNH MÌ","PHỞ"};
		jComBoBox_monanchinh= new JComboBox<String>(MonAnChinh);
		jPanel_MonChinh.add(jComBoBox_monanchinh);

		JPanel jPanel_MonPhu = new JPanel();
		String[] MonAnPhu = new String[]{"TRÀ SỮA","COCACOLA","BÁNH NGỌT"};
		list_buttonGroup_MonPhu = new JList<String>(MonAnPhu);
		jPanel_MonPhu.setLayout(new GridLayout());
		
		jPanel_MonPhu.add(list_buttonGroup_MonPhu);

		JPanel jPanel_LuaChon = new JPanel();
		jPanel_LuaChon.setLayout(new BorderLayout());
		jPanel_LuaChon.add(jPanel_MonChinh, BorderLayout.NORTH);
		jPanel_LuaChon.add(jPanel_MonPhu, BorderLayout.CENTER);

		this.add(jPanel_LuaChon, BorderLayout.CENTER);

		JPanel jPanel_ThanhToan = new JPanel();
		jPanel_ThanhToan.setLayout(new GridLayout(1, 2));
		jLabel_ThongTin = new JLabel();
		jLabel_ThongTin.setFont(new Font("Arial",Font.BOLD, 20));
		JButton jButton_ThanhToan = new JButton("Thanh Toán");
		jButton_ThanhToan.setFont(font);
		ActionListener thucDonController = new ThucDonController(this);
		jButton_ThanhToan.addActionListener(thucDonController);
		jPanel_ThanhToan.add(jLabel_ThongTin);
		jPanel_ThanhToan.add(jButton_ThanhToan);
		this.add(jPanel_ThanhToan, BorderLayout.SOUTH);

		this.setVisible(true);
	}

	public void hienThiKetQua() {
		String kq = "Món chính: " + this.thucDonModel.getLuaChon_MonChinh()
					+ "; Món phụ: " + this.thucDonModel.getLuaChon_MonPhu()
					+ "; Tổng tiền: " + this.thucDonModel.getTongTien();
		this.jLabel_ThongTin.setText(kq);
	}
}
