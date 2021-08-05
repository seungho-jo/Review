package project6.follow;

import java.util.ArrayList;
public class Service {
	Dao dao = new Dao();
	
	// 팔로워 리스트
	public ArrayList<Follow> followerList(String id) {
		ArrayList<Follow> flist = dao.followerList(id);
		int follower = 0;
		System.out.println("#"+id+"의 팔로워 리스트#");
		for(Follow f:flist) {
			System.out.println(f.getId());
			follower++;
		}
		System.out.println("#팔로워 수#");
		System.out.println(follower);
		return flist;
	}
	
	// 팔로잉 리스트
	public ArrayList<Follow> followingList(String id) {
		ArrayList<Follow> flist = dao.followingList(id);
		int following = 0;
		System.out.println("#"+id+"의 팔로잉 리스트#");
		for(Follow f:flist) {
			System.out.println(f.getId());
			following++;
		}
		System.out.println("#팔로잉 수#");
		System.out.println(following);
		return flist;
	}
	

}
