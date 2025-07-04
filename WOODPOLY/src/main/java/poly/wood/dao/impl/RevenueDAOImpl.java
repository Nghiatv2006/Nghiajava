package poly.wood.dao.impl;

import java.util.Date;
import java.util.List;
import poly.wood.dao.RevenueDAO;
import poly.wood.entity.Revenue;
import poly.wood.util.XQuery;

/**
 *
 * @author Nghia
 */
public class RevenueDAOImpl implements RevenueDAO {

    @Override
    public List<Revenue.ByCategory> getByCategory(Date begin, Date end) {
        String byCategorySql = "SELECT category.Name AS Category, "
                + "   sum(detail.UnitPrice * detail.Quantity * (1 - detail.Discount)) AS Revenue, "
                + "   sum(detail.Quantity) AS Quantity, "
                + "   min(detail.UnitPrice) AS MinPrice, "
                + "   max(detail.UnitPrice) AS MaxPrice, "
                + "   avg(detail.UnitPrice) AS AvgPrice "
                + "FROM BillDetails detail "
                + "   JOIN Woods wood ON wood.Id = detail.WoodId "
                + "   JOIN Categories category ON category.Id = wood.CategoryId "
                + "   JOIN Bills bill ON bill.Id = detail.BillId "
                + "WHERE bill.Status = 1 "
                + "   AND bill.Checkout IS NOT NULL "
                + "   AND bill.Checkout BETWEEN ? AND ? "
                + "GROUP BY category.Name "
                + "ORDER BY Revenue DESC";
        return XQuery.getBeanList(Revenue.ByCategory.class, byCategorySql, begin, end);
    }

    @Override
    public List<Revenue.ByUser> getByUser(Date begin, Date end) {
        String byUserSql = "SELECT bill.Username AS [User], "
                + "   sum(detail.UnitPrice * detail.Quantity * (1 - detail.Discount)) AS Revenue, "
                + "   count(DISTINCT detail.BillId) AS Quantity, "
                + "   min(bill.Checkin) AS FirstTime, "
                + "   max(bill.Checkin) AS LastTime "
                + "FROM BillDetails detail "
                + "   JOIN Bills bill ON bill.Id = detail.BillId "
                + "WHERE bill.Status = 1 "
                + "   AND bill.Checkout IS NOT NULL "
                + "   AND bill.Checkout BETWEEN ? AND ? "
                + "GROUP BY bill.Username "
                + "ORDER BY Revenue DESC";
        return XQuery.getBeanList(Revenue.ByUser.class, byUserSql, begin, end);
    }
}
