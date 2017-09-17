package com.myspringmvc.mvc.controller;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.w3c.dom.html.HTMLIsIndexElement;

import com.hankcs.hanlp.HanLP;
import com.hankcs.hanlp.collection.AhoCorasick.AhoCorasickDoubleArrayTrie;
import com.hankcs.hanlp.corpus.dependency.CoNll.CoNLLSentence;
import com.hankcs.hanlp.corpus.dependency.CoNll.CoNLLWord;
import com.hankcs.hanlp.dictionary.BaseSearcher;
import com.hankcs.hanlp.dictionary.CoreDictionary;
import com.hankcs.hanlp.dictionary.CoreSynonymDictionary;
import com.hankcs.hanlp.dictionary.CustomDictionary;
import com.hankcs.hanlp.dictionary.py.Pinyin;
import com.hankcs.hanlp.seg.Segment;
import com.hankcs.hanlp.seg.CRF.CRFSegment;
import com.hankcs.hanlp.seg.Dijkstra.DijkstraSegment;
import com.hankcs.hanlp.seg.NShort.NShortSegment;
import com.hankcs.hanlp.seg.common.Term;
import com.hankcs.hanlp.suggest.Suggester;
import com.hankcs.hanlp.tokenizer.IndexTokenizer;
import com.hankcs.hanlp.tokenizer.NLPTokenizer;
import com.hankcs.hanlp.tokenizer.SpeedTokenizer;
import com.hankcs.hanlp.tokenizer.StandardTokenizer;
import com.myspringmvc.entity.User;

@Controller
@RequestMapping("/hanlp")
public class HanLPController {

	public static void main(String[] args) {

		System.out.println("******第一个Demo******");
		System.out.println(HanLP.segment("你好，欢迎使用HanLP汉语处理包！"));

		System.out.println("******标准分词******");
		List<Term> termList = StandardTokenizer.segment("商品和服务");
		System.out.println(termList);

		System.out.println("******NLP分词******");
		List<Term> termList2 = NLPTokenizer.segment("中国科学院计算技术研究所的宗成庆教授正在教授自然语言处理课程");
		System.out.println(termList2);

		System.out.println("******索引分词******");
		List<Term> termList3 = IndexTokenizer.segment("主副食品");
		for (Term term : termList3) {
			System.out.println(term + " [" + term.offset + ":" + (term.offset + term.word.length()) + "]");
		}

		System.out.println("******N-最短路径分词******");
		Segment nShortSegment = new NShortSegment().enableCustomDictionary(false).enablePlaceRecognize(true)
				.enableOrganizationRecognize(true);
		Segment shortestSegment = new DijkstraSegment().enableCustomDictionary(false).enablePlaceRecognize(true)
				.enableOrganizationRecognize(true);
		String[] testCase = new String[] { "今天，刘志军案的关键人物,山西女商人丁书苗在市二中院出庭受审。", "刘喜杰石国祥会见吴亚琴先进事迹报告团成员", };
		for (String sentence : testCase) {
			System.out.println("N-最短分词：" + nShortSegment.seg(sentence) + "\n最短路分词：" + shortestSegment.seg(sentence));
		}

		System.out.println("******CRF分词******");
		// testCRF(); //测试失败

		System.out.println("******极速词典分词******");
		DemoHighSpeedSegment();

		System.out.println("******用户自定义词典******");
		DemoCustomDictionary();
		
		System.out.println("******中国人名识别******");
		String[] testCase2 = new String[]{
		        "签约仪式前，秦光荣、李纪恒、仇和等一同会见了参加签约的企业家。",
		        "王国强、高峰、汪洋、张朝阳光着头、韩寒、小四",
		        "张浩和胡健康复员回家了",
		        "王总和小丽结婚了",
		        "编剧邵钧林和稽道青说",
		        "这里有关天培的有关事迹",
		        "龚学平等领导,邓颖超生前",
		        };
		Segment segment = HanLP.newSegment().enableNameRecognize(true);
		for (String sentence : testCase2)
		{
		    List<Term> termList9 = segment.seg(sentence);
		    System.out.println(termList9);
		}
		
		
		System.out.println("******音译人名识别******");
		String[] testCase10 = new String[]{
                "一桶冰水当头倒下，微软的比尔盖茨、Facebook的扎克伯格跟桑德博格、亚马逊的贝索斯、苹果的库克全都不惜湿身入镜，这些硅谷的科技人，飞蛾扑火似地牺牲演出，其实全为了慈善。",
                "世界上最长的姓名是简森·乔伊·亚历山大·比基·卡利斯勒·达夫·埃利奥特·福克斯·伊维鲁莫·马尔尼·梅尔斯·帕特森·汤普森·华莱士·普雷斯顿。",
        };
		Segment segment10 = HanLP.newSegment().enableTranslatedNameRecognize(true);
		for (String sentence : testCase10)
		{
		    List<Term> termList10 = segment10.seg(sentence);
		    System.out.println(termList10);
		}	
		
		
		System.out.println("******11 日本人名识别******");
		String[] testCase11 = new String[]{
		        "北川景子参演了林诣彬导演的《速度与激情3》",
		        "林志玲亮相网友:确定不是波多野结衣？",
		};
		Segment segment11 = HanLP.newSegment().enableJapaneseNameRecognize(true);
		for (String sentence : testCase11)
		{
		    List<Term> termList11 = segment11.seg(sentence);
		    System.out.println(termList11);
		}	
		
		
		
		System.out.println("******12 地名识别******");
		String[] testCase12 = new String[]{
		        "武胜县新学乡政府大楼门前锣鼓喧天",
		        "蓝翔给宁夏固原市彭阳县红河镇黑牛沟村捐赠了挖掘机",
		};
		Segment segment12 = HanLP.newSegment().enablePlaceRecognize(true);
		for (String sentence : testCase12)
		{
		    List<Term> termList12 = segment12.seg(sentence);
		    System.out.println(termList12);
		}
		
		
		System.out.println("******13 机构名识别******");
		String[] testCase13 = new String[]{
		        "我在上海林原科技有限公司兼职工作，",
		        "我经常在台川喜宴餐厅吃饭，",
		        "偶尔去地中海影城看电影。",
		};
		Segment segment13 = HanLP.newSegment().enableOrganizationRecognize(true);
		for (String sentence : testCase13)
		{
		    List<Term> termList13 = segment13.seg(sentence);
		    System.out.println(termList13);
		}
		
		
		System.out.println("******14 关键词提取******");
		String content = "程序员(英文Programmer)是从事程序开发、维护的专业人员。一般将程序员分为程序设计人员和程序编码人员，但两者的界限并不非常清楚，特别是在中国。软件从业人员分为初级程序员、高级程序员、系统分析员和项目经理四大类。";
		List<String> keywordList = HanLP.extractKeyword(content, 5);
		System.out.println(keywordList);	
		
		
		System.out.println("******15 自动摘要******");
		String document = "算法可大致分为基本算法、数据结构的算法、数论算法、计算几何的算法、图的算法、动态规划以及数值分析、加密算法、排序算法、检索算法、随机化算法、并行算法、厄米变形模型、随机森林算法。\n" +
		        "算法可以宽泛的分为三类，\n" +
		        "一，有限的确定性算法，这类算法在有限的一段时间内终止。他们可能要花很长时间来执行指定的任务，但仍将在一定的时间内终止。这类算法得出的结果常取决于输入值。\n" +
		        "二，有限的非确定算法，这类算法在有限的时间内终止。然而，对于一个（或一些）给定的数值，算法的结果并不是唯一的或确定的。\n" +
		        "三，无限的算法，是那些由于没有定义终止定义条件，或定义的条件无法由输入的数据满足而不终止运行的算法。通常，无限算法的产生是由于未能确定的定义终止条件。";
		List<String> sentenceList = HanLP.extractSummary(document, 3);
		System.out.println(sentenceList);
		
		
		System.out.println("******16 短语提取******");
		String text = "算法工程师\n" +
		        "算法（Algorithm）是一系列解决问题的清晰指令，也就是说，能够对一定规范的输入，在有限时间内获得所要求的输出。" +
		        "如果一个算法有缺陷，或不适合于某个问题，执行这个算法将不会解决这个问题。不同的算法可能用不同的时间、" +
		        "空间或效率来完成同样的任务。一个算法的优劣可以用空间复杂度与时间复杂度来衡量。算法工程师就是利用算法处理事物的人。\n" +
		        "\n" +
		        "1职位简介\n" +
		        "算法工程师是一个非常高端的职位；\n" +
		        "专业要求：计算机、电子、通信、数学等相关专业；\n" +
		        "学历要求：本科及其以上的学历，大多数是硕士学历及其以上；\n" +
		        "语言要求：英语要求是熟练，基本上能阅读国外专业书刊；\n" +
		        "必须掌握计算机相关知识，熟练使用仿真工具MATLAB等，必须会一门编程语言。\n" +
		        "\n" +
		        "2研究方向\n" +
		        "视频算法工程师、图像处理算法工程师、音频算法工程师 通信基带算法工程师\n" +
		        "\n" +
		        "3目前国内外状况\n" +
		        "目前国内从事算法研究的工程师不少，但是高级算法工程师却很少，是一个非常紧缺的专业工程师。" +
		        "算法工程师根据研究领域来分主要有音频/视频算法处理、图像技术方面的二维信息算法处理和通信物理层、" +
		        "雷达信号处理、生物医学信号处理等领域的一维信息算法处理。\n" +
		        "在计算机音视频和图形图像技术等二维信息算法处理方面目前比较先进的视频处理算法：机器视觉成为此类算法研究的核心；" +
		        "另外还有2D转3D算法(2D-to-3D conversion)，去隔行算法(de-interlacing)，运动估计运动补偿算法" +
		        "(Motion estimation/Motion Compensation)，去噪算法(Noise Reduction)，缩放算法(scaling)，" +
		        "锐化处理算法(Sharpness)，超分辨率算法(Super Resolution),手势识别(gesture recognition),人脸识别(face recognition)。\n" +
		        "在通信物理层等一维信息领域目前常用的算法：无线领域的RRM、RTT，传送领域的调制解调、信道均衡、信号检测、网络优化、信号分解等。\n" +
		        "另外数据挖掘、互联网搜索算法也成为当今的热门方向。\n" +
		        "算法工程师逐渐往人工智能方向发展。";
		List<String> phraseList = HanLP.extractPhrase(text, 5);
		System.out.println(phraseList);
		
		System.out.println("******17 拼音转换******");
		DemoPinyin();
		
		System.out.println("******18 简繁转换******");
		DemoTraditionalChinese2SimplifiedChinese();
		
		
		System.out.println("******19 文本推荐******");
		DemoSuggester();
		
		System.out.println("******20 语义距离******");
		DemoWordDistance();
		
		System.out.println("*****21 依存句法解析******");
		//DemoDependencyParser();
		
		
	}
	
	
	
	/**
	 * 依存句法分析（神经网络句法模型需要-Xms1g -Xmx1g -Xmn512m）
	 * @author hankcs
	 */
	public static void DemoDependencyParser()
	{
	        CoNLLSentence sentence = HanLP.parseDependency("徐先生还具体帮助他确定了把画雄鹰、松鼠和麻雀作为主攻目标。");
	        System.out.println(sentence);
	        // 可以方便地遍历它
	        for (CoNLLWord word : sentence)
	        {
	            System.out.printf("%s --(%s)--> %s\n", word.LEMMA, word.DEPREL, word.HEAD.LEMMA);
	        }
	        // 也可以直接拿到数组，任意顺序或逆序遍历
	        CoNLLWord[] wordArray = sentence.getWordArray();
	        for (int i = wordArray.length - 1; i >= 0; i--)
	        {
	            CoNLLWord word = wordArray[i];
	            System.out.printf("%s --(%s)--> %s\n", word.LEMMA, word.DEPREL, word.HEAD.LEMMA);
	        }
	        // 还可以直接遍历子树，从某棵子树的某个节点一路遍历到虚根
	        CoNLLWord head = wordArray[12];
	        while ((head = head.HEAD) != null)
	        {
	            if (head == CoNLLWord.ROOT) System.out.println(head.LEMMA);
	            else System.out.printf("%s --(%s)--> ", head.LEMMA, head.DEPREL);
	        }
	    
	}	
	
	
	/**
	 * 语义距离
	 * @author hankcs
	 */
	public static void DemoWordDistance()
	{
	        String[] wordArray = new String[]
	                {
	                        "香蕉",
	                        "苹果",
	                        "白菜",
	                        "水果",
	                        "蔬菜",
	                        "自行车",
	                        "公交车",
	                        "飞机",
	                        "买",
	                        "卖",
	                        "购入",
	                        "新年",
	                        "春节",
	                        "丢失",
	                        "补办",
	                        "办理",
	                        "送给",
	                        "寻找",
	                        "孩子",
	                        "教室",
	                        "教师",
	                        "会计",
	                };
	        for (String a : wordArray)
	        {
	            for (String b : wordArray)
	            {
	                System.out.println(a + "\t" + b + "\t之间的距离是\t" + CoreSynonymDictionary.distance(a, b));
	            }
	        }
	}	
	
	
	/**
	 * 文本推荐(句子级别，从一系列句子中挑出与输入句子最相似的那一个)
	 * @author hankcs
	 */
	public static void DemoSuggester()
	{
	        Suggester suggester = new Suggester();
	        String[] titleArray =
	        (
	                "威廉王子发表演说 呼吁保护野生动物\n" +
	                "《时代》年度人物最终入围名单出炉 普京马云入选\n" +
	                "“黑格比”横扫菲：菲吸取“海燕”经验及早疏散\n" +
	                "日本保密法将正式生效 日媒指其损害国民知情权\n" +
	                "英报告说空气污染带来“公共健康危机”"
	        ).split("\\n");
	        for (String title : titleArray)
	        {
	            suggester.addSentence(title);
	        }
	        System.out.println(suggester.suggest("发言", 1));       // 语义
	        System.out.println(suggester.suggest("危机公共", 1));   // 字符
	        System.out.println(suggester.suggest("mayun", 1));      // 拼音
	 
	}	
	
	
	/**
	 * 简繁转换
	 * @author hankcs
	 */
	public static void DemoTraditionalChinese2SimplifiedChinese()
	{
	        System.out.println(HanLP.convertToTraditionalChinese("用笔记本电脑写程序"));
	        System.out.println(HanLP.convertToSimplifiedChinese("「以後等妳當上皇后，就能買士多啤梨慶祝了」"));
	    
	}	
	
	
	/**
	 * 汉字转拼音
	 * @author hankcs
	 */
	public static void DemoPinyin()
	{
	        String text = "重载不是重任";
	        List<Pinyin> pinyinList = HanLP.convertToPinyinList(text);
	        System.out.print("原文,");
	        for (char c : text.toCharArray())
	        {
	            System.out.printf("%c,", c);
	        }
	        System.out.println();
	        System.out.print("拼音（数字音调）,");
	        for (Pinyin pinyin : pinyinList)
	        {
	            System.out.printf("%s,", pinyin);
	        }
	        System.out.println();
	        System.out.print("拼音（符号音调）,");
	        for (Pinyin pinyin : pinyinList)
	        {
	            System.out.printf("%s,", pinyin.getPinyinWithToneMark());
	        }
	        System.out.println();
	        System.out.print("拼音（无音调）,");
	        for (Pinyin pinyin : pinyinList)
	        {
	            System.out.printf("%s,", pinyin.getPinyinWithoutTone());
	        }
	        System.out.println();
	        System.out.print("声调,");
	        for (Pinyin pinyin : pinyinList)
	        {
	            System.out.printf("%s,", pinyin.getTone());
	        }
	        System.out.println();
	        System.out.print("声母,");
	        for (Pinyin pinyin : pinyinList)
	        {
	            System.out.printf("%s,", pinyin.getShengmu());
	        }
	        System.out.println();
	        System.out.print("韵母,");
	        for (Pinyin pinyin : pinyinList)
	        {
	            System.out.printf("%s,", pinyin.getYunmu());
	        }
	        System.out.println();
	        System.out.print("输入法头,");
	        for (Pinyin pinyin : pinyinList)
	        {
	            System.out.printf("%s,", pinyin.getHead());
	        }
	        System.out.println();
	    
	}	
	

	public static void DemoCustomDictionary() {
		// 动态增加
		CustomDictionary.add("攻城狮");
		// 强行插入
		CustomDictionary.insert("白富美", "nz 1024");
		// 删除词语（注释掉试试）
		// CustomDictionary.remove("攻城狮");
		System.out.println(CustomDictionary.add("单身狗", "nz 1024 n 1"));
		System.out.println(CustomDictionary.get("单身狗"));

		String text = "攻城狮逆袭单身狗，迎娶白富美，走上人生巅峰"; // 怎么可能噗哈哈！

		// DoubleArrayTrie分词
		final char[] charArray = text.toCharArray();
		CustomDictionary.parseText(charArray, new AhoCorasickDoubleArrayTrie.IHit<CoreDictionary.Attribute>() {
			@Override
			public void hit(int begin, int end, CoreDictionary.Attribute value) {
				System.out.printf("[%d:%d]=%s %s\n", begin, end, new String(charArray, begin, end - begin), value);
			}
		});
		// 首字哈希之后二分的trie树分词
		BaseSearcher searcher = CustomDictionary.getSearcher(text);
		Map.Entry entry;
		while ((entry = searcher.next()) != null) {
			System.out.println(entry);
		}

		// 标准分词
		System.out.println(HanLP.segment(text));

		// Note:动态增删不会影响词典文件
		// 目前CustomDictionary使用DAT储存词典文件中的词语，用BinTrie储存动态加入的词语，前者性能高，后者性能低
		// 之所以保留动态增删功能，一方面是历史遗留特性，另一方面是调试用；未来可能会去掉动态增删特性。
	}

	/**
	 * 演示极速分词，基于AhoCorasickDoubleArrayTrie实现的词典分词，适用于“高吞吐量”“精度一般”的场合
	 * 
	 * @author hankcs
	 */
	public static void DemoHighSpeedSegment() {
		String text = "江西鄱阳湖干枯，中国最大淡水湖变成大草原";
		System.out.println(SpeedTokenizer.segment(text));
		long start = System.currentTimeMillis();
		int pressure = 1000000;
		for (int i = 0; i < pressure; ++i) {
			SpeedTokenizer.segment(text);
		}
		double costTime = (System.currentTimeMillis() - start) / (double) 1000;
		System.out.printf("分词速度：%.2f字每秒", text.length() * pressure / costTime);
	}

	/**
	 * CRF分词(在最新训练的未压缩100MB模型下，能够取得较好的效果，可以投入生产环境)
	 *
	 * @author hankcs
	 */
	public static void testCRF() {
		HanLP.Config.ShowTermNature = false; // 关闭词性显示
		Segment segment = new CRFSegment();
		String[] sentenceArray = new String[] { "HanLP是由一系列模型与算法组成的Java工具包，目标是普及自然语言处理在生产环境中的应用。", "鐵桿部隊憤怒情緒集結 馬英九腹背受敵", // 繁体无压力
				"馬英九回應連勝文“丐幫說”：稱黨內同志談話應謹慎", "高锰酸钾，强氧化剂，紫红色晶体，可溶于水，遇乙醇即被还原。常用作消毒剂、水净化剂、氧化剂、漂白剂、毒气吸收剂、二氧化碳精制剂等。", // 专业名词有一定辨识能力
				"《夜晚的骰子》通过描述浅草的舞女在暗夜中扔骰子的情景,寄托了作者对庶民生活区的情感", // 非新闻语料
				"这个像是真的[委屈]前面那个打扮太江户了，一点不上品...@hankcs", // 微博
				"鼎泰丰的小笼一点味道也没有...每样都淡淡的...淡淡的，哪有食堂2A的好次", "克里斯蒂娜·克罗尔说：不，我不是虎妈。我全家都热爱音乐，我也鼓励他们这么做。",
				"今日APPS：Sago Mini Toolbox培养孩子动手能力", "财政部副部长王保安调任国家统计局党组书记", "2.34米男子娶1.53米女粉丝 称夫妻生活没问题", "你看过穆赫兰道吗",
				"乐视超级手机能否承载贾布斯的生态梦" };
		for (String sentence : sentenceArray) {
			List<Term> termList = segment.seg(sentence);
			System.out.println(termList);
		}
	}

}
