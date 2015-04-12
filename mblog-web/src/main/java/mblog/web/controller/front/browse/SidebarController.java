/**
 * 
 */
package mblog.web.controller.front.browse;

import java.util.List;

import mblog.core.planet.PostPlanet;
import mblog.core.planet.TagPlanet;
import mblog.core.pojos.Post;
import mblog.core.pojos.Tag;
import mblog.web.controller.BaseController;
import mtons.modules.pojos.UserContextHolder;
import mtons.modules.pojos.UserProfile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 侧边栏数据加载
 * 
 * @author langhsu
 *
 */
@Controller
@RequestMapping("/browse")
public class SidebarController extends BaseController {
	@Autowired
	private PostPlanet postPlanet;
	@Autowired
	private TagPlanet tagPlanet;
	
	@RequestMapping("/recents_json")
	public @ResponseBody List<Post> recent() {
		UserProfile up = UserContextHolder.getUserProfile();
		long ignoreUserId = 0;
		if (up != null) {
			ignoreUserId = up.getId();
		}
		List<Post> rets = postPlanet.findRecents(8, ignoreUserId);
		return rets;
	}
	
	@RequestMapping("/hots_json")
	public @ResponseBody List<Post> hots() {
		UserProfile up = UserContextHolder.getUserProfile();
		long ignoreUserId = 0;
		if (up != null) {
			ignoreUserId = up.getId();
		}
		List<Post> rets = postPlanet.findHots(8, ignoreUserId);
		return rets;
	}
	
	@RequestMapping("/hot_tags_json")
	public @ResponseBody List<Tag> hotTags() {
		List<Tag> rets = tagPlanet.topTags(12, false);
		return rets;
	}
	
}
