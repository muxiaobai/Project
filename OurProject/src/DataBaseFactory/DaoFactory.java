package DataBaseFactory;

import DataBaseDao.GoodsEvaluationDao;
import DataBaseDao.GoodsgradeDao;
import DataBaseDao.GoodsinfoDao;
import DataBaseDao.GoodsvideoDao;
import DataBaseDao.GovnmtDao;
import DataBaseDao.OrderDao;
import DataBaseDao.OrderdetailDao;
import DataBaseDao.OtherinfoDao;
import DataBaseDao.PayexamDao;
import DataBaseDao.RoleDao;
import DataBaseProxy.GoodsEvaluationDaoProxy;
import DataBaseProxy.GoodsgradeDaoProxy;
import DataBaseProxy.GoodsinfoDaoProxy;
import DataBaseProxy.GoodsvideoDaoProxy;
import DataBaseProxy.GovnmtDaoProxy;
import DataBaseProxy.OrderDaoProxy;
import DataBaseProxy.OrderdetailDaoProxy;
import DataBaseProxy.OtherinfoDaoProxy;
import DataBaseProxy.PayexamDaoProxy;
import DataBaseProxy.RoleDaoProxy;
import DataBaseDao.BkgoodsDao;
import DataBaseDao.BkgoodsDetailDao;
import DataBaseDao.CameraDao;
import DataBaseDao.CategoryDao;
import DataBaseDao.ContractDao;
import DataBaseDao.ContractDetailDao;
import DataBaseDao.ContractMediaDao;
import DataBaseDao.DepartmentDao;
import DataBaseDao.GoodsDao;
import DataBaseDao.PointDao;
import DataBaseDao.StaEvaluationDao;
import DataBaseDao.StaffDao;
import DataBaseDao.StationDao;
import DataBaseDao.SupplierDao;
import DataBaseDao.SuppliergoodsDao;
import DataBaseDao.SupplierneedDao;
import DataBaseDao.TaskDao;
import DataBaseDao.UserDao;
import DataBaseDao.VideoDao;
import DataBaseProxy.BkgoodsDaoProxy;
import DataBaseProxy.BkgoodsDetailDaoProxy;
import DataBaseProxy.CameraDaoProxy;
import DataBaseProxy.CategoryDaoProxy;
import DataBaseProxy.ContractDaoProxy;
import DataBaseProxy.ContractDetailDaoProxy;
import DataBaseProxy.ContractMediaDaoProxy;
import DataBaseProxy.DepartmentDaoProxy;
import DataBaseProxy.GoodsDaoProxy;
import DataBaseProxy.PointDaoProxy;
import DataBaseProxy.StaEvaluationDaoProxy;
import DataBaseProxy.StaffDaoProxy;
import DataBaseProxy.StationDaoProxy;
import DataBaseProxy.SupplierDaoProxy;
import DataBaseProxy.SuppliergoodsDaoProxy;
import DataBaseProxy.SupplierneedDaoProxy;
import DataBaseProxy.TaskDaoProxy;
import DataBaseProxy.UserDaoProxy;
import DataBaseProxy.VideoDaoProxy;
import DataBaseDao.AddressDao;
import DataBaseProxy.AddressDaoProxy;

public class DaoFactory {
	public static RoleDao getRoleDaoInstance() throws Exception{
		return new RoleDaoProxy() ;
	}
	public static GoodsEvaluationDao getGoodsEvaluationDaoInstance() throws Exception{
		return new GoodsEvaluationDaoProxy() ;
		}
		public static GoodsgradeDao getGoodsgradeDaoInstance() throws Exception{
			return new GoodsgradeDaoProxy() ;
		}
		public static GoodsinfoDao getGoodsinfoDaoInstance() throws Exception{
			return new GoodsinfoDaoProxy() ;
		}
		public static GoodsvideoDao getGoodsvideoDaoInstance() throws Exception{
			return new GoodsvideoDaoProxy() ;
		}
		public static GovnmtDao getGovnmtDaoInstance() throws Exception{
			return new GovnmtDaoProxy() ;
		}
		public static OrderDao getOrderDaoInstance() throws Exception{
			return new OrderDaoProxy() ;
		}
		public static OrderdetailDao getOrderdetailDaoInstance() throws Exception{
			return new OrderdetailDaoProxy() ;
		}
		public static OtherinfoDao getOtherinfoDaoInstance() throws Exception{
			return new OtherinfoDaoProxy() ;
		}
		public static PayexamDao getPayexamDaoInstance() throws Exception{
			return new PayexamDaoProxy() ;
		}
        public static StaEvaluationDao getStaEvaluationDaoInstance() throws Exception{
		return new StaEvaluationDaoProxy() ;
	}
	public static StaffDao getStaffDaoInstance() throws Exception{
		return new StaffDaoProxy() ;
	}
	public static StationDao getStationDaoInstance() throws Exception{
		return new StationDaoProxy() ;
	}
	public static SupplierDao getSupplierDaoInstance() throws Exception{
		return new SupplierDaoProxy() ;
	}
	public static SuppliergoodsDao getSuppliergoodsDaoInstance() throws Exception{
		return new SuppliergoodsDaoProxy() ;
	}
	public static SupplierneedDao getSupplierneedDaoInstance() throws Exception{
		return new SupplierneedDaoProxy() ;
	}
	public static TaskDao getTaskDaoInstance() throws Exception{
		return new TaskDaoProxy() ;
	}public static UserDao getUserDaoInstance() throws Exception{
		return new UserDaoProxy() ;
	}public static VideoDao getVideoDaoInstance() throws Exception{
		return new VideoDaoProxy() ;
	}

	public static AddressDao getAddressDaoInstance() throws Exception{
		return new AddressDaoProxy() ;
	}
	public static BkgoodsDao getBkgoodsDaoInstance() throws Exception{
		return new BkgoodsDaoProxy() ;
	}
	public static BkgoodsDetailDao getBkgoodsDetailDaoInstance() throws Exception{
		return new BkgoodsDetailDaoProxy() ;
	}
	public static CameraDao getCameraDaoInstance() throws Exception{
		return new CameraDaoProxy() ;
	}
	public static CategoryDao getCategoryDaoInstance() throws Exception{
		return new CategoryDaoProxy() ;
	}
	public static ContractDao getContractDaoInstance() throws Exception{
		return new ContractDaoProxy() ;
	}
	public static ContractDetailDao getContractDetailDaoInstance() throws Exception{
		return new ContractDetailDaoProxy() ;
	}
	public static ContractMediaDao getContractMediaDaoInstance() throws Exception{
		return new ContractMediaDaoProxy() ;
	}
	public static DepartmentDao getDepartmentDaoInstance() throws Exception{
		return new DepartmentDaoProxy() ;
	}
	public static GoodsDao getGoodsDaoInstance() throws Exception{
		return new GoodsDaoProxy() ;
	}
	public static PointDao getPointDaoInstance() throws Exception{
		return new PointDaoProxy() ;
	}
	
}
