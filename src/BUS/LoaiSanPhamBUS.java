package BUS;

import dao.LoaiSanPhamDAO;
import dto.LoaiSanPhamDTO;

import javax.swing.*;
import java.sql.SQLException;
import java.util.List;

public class LoaiSanPhamBUS {
    private final LoaiSanPhamDAO dao = new LoaiSanPhamDAO();

    // Lấy tất cả loại sản phẩm
    public List<LoaiSanPhamDTO> layTatCa() {
        try {
            return dao.getAll();
        } catch (SQLException e) {
            e.printStackTrace();
            return List.of();
        }
    }

    // Thêm loại sản phẩm
    public boolean them(String maLoai, String tenLoai, String trangThai, String moTa) {
        try {
            dao.insert(new LoaiSanPhamDTO(maLoai, tenLoai, trangThai, moTa));
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Lỗi khi thêm loại sản phẩm: " + e.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    // Xóa loại sản phẩm theo mã
    public boolean xoa(String maLoai) {
        try {
            dao.delete(maLoai);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Cập nhật loại sản phẩm
    public boolean sua(String maLoai, String tenLoai, String trangThai, String moTa) {
        try {
            dao.update(new LoaiSanPhamDTO(maLoai, tenLoai, trangThai, moTa));
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Tìm theo mã
    public LoaiSanPhamDTO timTheoMa(String maLoai) {
        try {
            return dao.findByMaLoai(maLoai);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    // Tìm gần đúng theo tên
    public List<LoaiSanPhamDTO> timTheoTen(String keyword) {
        try {
            return dao.findByTenLoai(keyword);
        } catch (SQLException e) {
            e.printStackTrace();
            return List.of();
        }
    }
}
