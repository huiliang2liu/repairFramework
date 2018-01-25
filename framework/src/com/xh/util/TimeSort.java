package com.xh.util;

import java.util.List;

public class TimeSort {
	/**
	 * 
	 * 时间类
	 * 
	 */
	private List<String> list;
	private String separator;
	private String[] stSort;

	/**
	 * 
	 * @param list是时间数组
	 *            ，separator是时间格式的分隔符，比如说“2014-05-6”他的分隔符就是“-” 时间先后顺序，年 月 日 时 分
	 *            秒，格式要一致
	 */
	public TimeSort(List<String> list, String separator) {
		// TODO Auto-generated constructor stub
		this.list = list;
		this.separator = separator;
		this.stSort = list.toArray(new String[list.size()]);
	}

	private int timePrecision(String time, String separator) {
		if ((null == time || "".equals(time))
				|| (null == separator || "".equals(separator)))
			return 0;
		switch (time.split(separator).length) {
		case 1:
			System.out.println("Time precision for years");
			return 1;
		case 2:
			System.out.println("Time precision for months");
			return 2;
		case 3:
			System.out.println("Time precision for the day");
			return 3;
		case 4:
			System.out.println("Accuracy of time too");
			return 4;
		case 5:
			System.out.println("For precision time points");
			return 5;
		case 6:
			System.out.println("Accuracy for the second time");
			return 6;

		default:
			return 7;
		}

	}

	public void ascend() {
		switch (timePrecision(stSort[0], separator)) {
		case 0:
			System.out.println("没有输入时间不需要排序");
			break;
		case 1:
			System.out.println("输入的时间精度为年，只需要比较年");
			for (int i = 0; i < stSort.length - 1; i++) {
				for (int j = i; j < stSort.length; j++) {
					int time1 = Integer.parseInt(stSort[i]);
					int time2 = Integer.parseInt(stSort[j]);
					String exchangeCapacity;
					if (time1 < time2) {
						exchangeCapacity = stSort[i];
						stSort[i] = stSort[j];
						stSort[j] = exchangeCapacity;
					}
				}
			}
			break;
		case 2:
			System.out.println("输入的时间精度为月，先比较年，年相同比较月");
			for (int i = 0; i < stSort.length - 1; i++) {
				for (int j = i; j < stSort.length; j++) {
					int time1 = Integer.parseInt(stSort[i].split(separator)[0]);
					int time2 = Integer.parseInt(stSort[j].split(separator)[0]);
					int time11 = Integer
							.parseInt(stSort[i].split(separator)[1]);
					int time21 = Integer
							.parseInt(stSort[j].split(separator)[1]);
					String exchangeCapacity;
					if (time1 < time2) {
						exchangeCapacity = stSort[i];
						stSort[i] = stSort[j];
						stSort[j] = exchangeCapacity;
					}
					if (time1 == time2) {
						if (time11 < time21) {
							exchangeCapacity = stSort[i];
							stSort[i] = stSort[j];
							stSort[j] = exchangeCapacity;
						}
					}
				}
			}
			break;
		case 3:
			System.out.println("输入的时间精度为日，先比较年，年相同比较月，月相同比较日");
			for (int i = 0; i < stSort.length - 1; i++) {
				for (int j = i; j < stSort.length; j++) {
					int time1 = Integer.parseInt(stSort[i].split(separator)[0]);
					int time2 = Integer.parseInt(stSort[j].split(separator)[0]);
					int time11 = Integer
							.parseInt(stSort[i].split(separator)[1]);
					int time21 = Integer
							.parseInt(stSort[j].split(separator)[1]);
					int time12 = Integer
							.parseInt(stSort[i].split(separator)[2]);
					int time22 = Integer
							.parseInt(stSort[j].split(separator)[2]);
					String exchangeCapacity;
					if (time1 < time2) {
						exchangeCapacity = stSort[i];
						stSort[i] = stSort[j];
						stSort[j] = exchangeCapacity;
					}
					// System.out
					// .println("这是 time1=" + time1 + "，这是 time2=" + time2
					// + "这是相等=" + (time1 == time2 ? "相等" : "不想等"));
					if (time1 == time2) {

						if (time11 < time21) {
							exchangeCapacity = stSort[i];
							stSort[i] = stSort[j];
							stSort[j] = exchangeCapacity;
						}
						if (time11 == time21)
							if (time12 < time22) {
								exchangeCapacity = stSort[i];
								stSort[i] = stSort[j];
								stSort[j] = exchangeCapacity;
							}
					}

				}
			}
			break;
		case 4:
			System.out.println("输入的时间精度为时，先比较年，年相同比较月，月相同比较日，日相同比较时");
			for (int i = 0; i < stSort.length - 1; i++) {
				for (int j = i; j < stSort.length; j++) {
					int time1 = Integer.parseInt(stSort[i].split(separator)[0]);
					int time2 = Integer.parseInt(stSort[j].split(separator)[0]);
					int time11 = Integer
							.parseInt(stSort[i].split(separator)[1]);
					int time21 = Integer
							.parseInt(stSort[j].split(separator)[1]);
					int time12 = Integer
							.parseInt(stSort[i].split(separator)[2]);
					int time22 = Integer
							.parseInt(stSort[j].split(separator)[2]);
					int time13 = Integer
							.parseInt(stSort[i].split(separator)[3]);
					int time23 = Integer
							.parseInt(stSort[j].split(separator)[3]);
					String exchangeCapacity;
					if (time1 < time2) {
						exchangeCapacity = stSort[i];
						stSort[i] = stSort[j];
						stSort[j] = exchangeCapacity;
					}
					if (time1 == time2) {
						if (time11 < time21) {
							exchangeCapacity = stSort[i];
							stSort[i] = stSort[j];
							stSort[j] = exchangeCapacity;
						}
						if (time11 == time21) {

							if (time12 < time22) {
								exchangeCapacity = stSort[i];
								stSort[i] = stSort[j];
								stSort[j] = exchangeCapacity;
							}
							if (time12 == time22)
								if (time13 < time23) {
									exchangeCapacity = stSort[i];
									stSort[i] = stSort[j];
									stSort[j] = exchangeCapacity;
								}
						}
					}
				}
			}
			break;
		case 5:
			System.out.println("输入的时间精度为分，先比较年，年相同比较月，月相同比较日，日相同比较时，时相同比较分");
			for (int i = 0; i < stSort.length - 1; i++) {
				for (int j = i; j < stSort.length; j++) {
					int time1 = Integer.parseInt(stSort[i].split(separator)[0]);
					int time2 = Integer.parseInt(stSort[j].split(separator)[0]);
					int time11 = Integer
							.parseInt(stSort[i].split(separator)[1]);
					int time21 = Integer
							.parseInt(stSort[j].split(separator)[1]);
					int time12 = Integer
							.parseInt(stSort[i].split(separator)[2]);
					int time22 = Integer
							.parseInt(stSort[j].split(separator)[2]);
					int time13 = Integer
							.parseInt(stSort[i].split(separator)[3]);
					int time23 = Integer
							.parseInt(stSort[j].split(separator)[3]);
					int time14 = Integer
							.parseInt(stSort[i].split(separator)[4]);
					int time24 = Integer
							.parseInt(stSort[j].split(separator)[4]);
					String exchangeCapacity;
					if (time1 < time2) {
						exchangeCapacity = stSort[i];
						stSort[i] = stSort[j];
						stSort[j] = exchangeCapacity;
					}
					if (time1 == time2) {
						if (time11 < time21) {
							exchangeCapacity = stSort[i];
							stSort[i] = stSort[j];
							stSort[j] = exchangeCapacity;
						}
						if (time11 == time21) {

							if (time12 < time22) {
								exchangeCapacity = stSort[i];
								stSort[i] = stSort[j];
								stSort[j] = exchangeCapacity;
							}
							if (time12 == time22) {

								if (time13 < time23) {
									exchangeCapacity = stSort[i];
									stSort[i] = stSort[j];
									stSort[j] = exchangeCapacity;
								}
								if (time13 == time23)
									if (time14 < time24) {
										exchangeCapacity = stSort[i];
										stSort[i] = stSort[j];
										stSort[j] = exchangeCapacity;
									}
							}
						}
					}
				}
			}
			break;
		case 6:
			System.out
					.println("输入的时间精度为秒，先比较年，年相同比较月，月相同比较日，日相同比较时，时相同比较分，分相同比较秒");
			for (int i = 0; i < stSort.length - 1; i++) {
				for (int j = i; j < stSort.length; j++) {
					int time1 = Integer.parseInt(stSort[i].split(separator)[0]);
					int time2 = Integer.parseInt(stSort[j].split(separator)[0]);
					int time11 = Integer
							.parseInt(stSort[i].split(separator)[1]);
					int time21 = Integer
							.parseInt(stSort[j].split(separator)[1]);
					int time12 = Integer
							.parseInt(stSort[i].split(separator)[2]);
					int time22 = Integer
							.parseInt(stSort[j].split(separator)[2]);
					int time13 = Integer
							.parseInt(stSort[i].split(separator)[3]);
					int time23 = Integer
							.parseInt(stSort[j].split(separator)[3]);
					int time14 = Integer
							.parseInt(stSort[i].split(separator)[4]);
					int time24 = Integer
							.parseInt(stSort[j].split(separator)[4]);
					int time15 = Integer
							.parseInt(stSort[i].split(separator)[5]);
					int time25 = Integer
							.parseInt(stSort[j].split(separator)[5]);
					String exchangeCapacity;
					if (time1 < time2) {
						exchangeCapacity = stSort[i];
						stSort[i] = stSort[j];
						stSort[j] = exchangeCapacity;
					}
					if (time1 == time2) {
						if (time11 < time21) {
							exchangeCapacity = stSort[i];
							stSort[i] = stSort[j];
							stSort[j] = exchangeCapacity;
						}
						if (time11 == time21) {

							if (time12 < time22) {
								exchangeCapacity = stSort[i];
								stSort[i] = stSort[j];
								stSort[j] = exchangeCapacity;
							}
							if (time12 == time22) {

								if (time13 < time23) {
									exchangeCapacity = stSort[i];
									stSort[i] = stSort[j];
									stSort[j] = exchangeCapacity;
								}
								if (time13 == time23) {

									if (time14 < time24) {
										exchangeCapacity = stSort[i];
										stSort[i] = stSort[j];
										stSort[j] = exchangeCapacity;
									}
									if (time14 == time24)
										if (time15 < time25) {
											exchangeCapacity = stSort[i];
											stSort[i] = stSort[j];
											stSort[j] = exchangeCapacity;
										}
								}
							}
						}
					}
				}
			}
			break;

		default:
			break;
		}
	}

	public void order() {
		switch (timePrecision(stSort[0], separator)) {
		case 0:
			System.out.println("没有输入时间不需要排序");
			break;
		case 1:
			System.out.println("输入的时间精度为年，只需要比较年");
			for (int i = 0; i < stSort.length - 1; i++) {
				for (int j = i; j < stSort.length; j++) {
					int time1 = Integer.parseInt(stSort[i]);
					int time2 = Integer.parseInt(stSort[j]);
					String exchangeCapacity;
					if (time1 > time2) {
						exchangeCapacity = stSort[i];
						stSort[i] = stSort[j];
						stSort[j] = exchangeCapacity;
					}
				}
			}
			break;
		case 2:
			System.out.println("输入的时间精度为月，先比较年，年相同比较月");
			for (int i = 0; i < stSort.length - 1; i++) {
				for (int j = i; j < stSort.length; j++) {
					int time1 = Integer.parseInt(stSort[i].split(separator)[0]);
					int time2 = Integer.parseInt(stSort[j].split(separator)[0]);
					int time11 = Integer
							.parseInt(stSort[i].split(separator)[1]);
					int time21 = Integer
							.parseInt(stSort[j].split(separator)[1]);
					String exchangeCapacity;
					if (time1 > time2) {
						exchangeCapacity = stSort[i];
						stSort[i] = stSort[j];
						stSort[j] = exchangeCapacity;
					}
					if (time1 == time2) {
						if (time11 > time21) {
							exchangeCapacity = stSort[i];
							stSort[i] = stSort[j];
							stSort[j] = exchangeCapacity;
						}
					}
				}
			}
			break;
		case 3:
			System.out.println("输入的时间精度为日，先比较年，年相同比较月，月相同比较日");
			for (int i = 0; i < stSort.length - 1; i++) {
				for (int j = i + 1; j < stSort.length; j++) {
					int time1 = Integer.parseInt(stSort[i].split(separator)[0]);
					int time2 = Integer.parseInt(stSort[j].split(separator)[0]);
					int time11 = Integer
							.parseInt(stSort[i].split(separator)[1]);
					int time21 = Integer
							.parseInt(stSort[j].split(separator)[1]);
					int time12 = Integer
							.parseInt(stSort[i].split(separator)[2]);
					int time22 = Integer
							.parseInt(stSort[j].split(separator)[2]);
					String exchangeCapacity;
					// System.out.println("这是 time1" + time1 + "，这是 time2" +
					// time2
					// + ",这是循环的步数" + i);
					if (time1 > time2) {
						exchangeCapacity = stSort[i];
						stSort[i] = stSort[j];
						stSort[j] = exchangeCapacity;
					}
					if (time1 == time2) {
						if (time11 > time21) {
							// System.out.println("===============我是纯洁的分隔线");
							exchangeCapacity = stSort[i];
							stSort[i] = stSort[j];
							stSort[j] = exchangeCapacity;
						}
						if (time11 == time21)
							if (time12 > time22) {
								exchangeCapacity = stSort[i];
								stSort[i] = stSort[j];
								stSort[j] = exchangeCapacity;
							}
					}
				}
			}
			break;
		case 4:
			System.out.println("输入的时间精度为时，先比较年，年相同比较月，月相同比较日，日相同比较时");
			for (int i = 0; i < stSort.length - 1; i++) {
				for (int j = i; j < stSort.length; j++) {
					int time1 = Integer.parseInt(stSort[i].split(separator)[0]);
					int time2 = Integer.parseInt(stSort[j].split(separator)[0]);
					int time11 = Integer
							.parseInt(stSort[i].split(separator)[1]);
					int time21 = Integer
							.parseInt(stSort[j].split(separator)[1]);
					int time12 = Integer
							.parseInt(stSort[i].split(separator)[2]);
					int time22 = Integer
							.parseInt(stSort[j].split(separator)[2]);
					int time13 = Integer
							.parseInt(stSort[i].split(separator)[3]);
					int time23 = Integer
							.parseInt(stSort[j].split(separator)[3]);
					String exchangeCapacity;
					if (time1 > time2) {
						exchangeCapacity = stSort[i];
						stSort[i] = stSort[j];
						stSort[j] = exchangeCapacity;
					}
					if (time1 == time2) {
						if (time11 > time21) {
							exchangeCapacity = stSort[i];
							stSort[i] = stSort[j];
							stSort[j] = exchangeCapacity;
						}
						if (time11 == time21) {

							if (time12 > time22) {
								exchangeCapacity = stSort[i];
								stSort[i] = stSort[j];
								stSort[j] = exchangeCapacity;
							}
							if (time12 == time22)
								if (time13 > time23) {
									exchangeCapacity = stSort[i];
									stSort[i] = stSort[j];
									stSort[j] = exchangeCapacity;
								}
						}
					}
				}
			}
			break;
		case 5:
			System.out.println("输入的时间精度为分，先比较年，年相同比较月，月相同比较日，日相同比较时，时相同比较分");
			for (int i = 0; i < stSort.length - 1; i++) {
				for (int j = i; j < stSort.length; j++) {
					int time1 = Integer.parseInt(stSort[i].split(separator)[0]);
					int time2 = Integer.parseInt(stSort[j].split(separator)[0]);
					int time11 = Integer
							.parseInt(stSort[i].split(separator)[1]);
					int time21 = Integer
							.parseInt(stSort[j].split(separator)[1]);
					int time12 = Integer
							.parseInt(stSort[i].split(separator)[2]);
					int time22 = Integer
							.parseInt(stSort[j].split(separator)[2]);
					int time13 = Integer
							.parseInt(stSort[i].split(separator)[3]);
					int time23 = Integer
							.parseInt(stSort[j].split(separator)[3]);
					int time14 = Integer
							.parseInt(stSort[i].split(separator)[4]);
					int time24 = Integer
							.parseInt(stSort[j].split(separator)[4]);
					String exchangeCapacity;
					if (time1 > time2) {
						exchangeCapacity = stSort[i];
						stSort[i] = stSort[j];
						stSort[j] = exchangeCapacity;
					}
					if (time1 == time2) {
						if (time11 > time21) {
							exchangeCapacity = stSort[i];
							stSort[i] = stSort[j];
							stSort[j] = exchangeCapacity;
						}
						if (time11 == time21) {

							if (time12 > time22) {
								exchangeCapacity = stSort[i];
								stSort[i] = stSort[j];
								stSort[j] = exchangeCapacity;
							}
							if (time12 == time22) {

								if (time13 > time23) {
									exchangeCapacity = stSort[i];
									stSort[i] = stSort[j];
									stSort[j] = exchangeCapacity;
								}
								if (time13 == time23)
									if (time14 > time24) {
										exchangeCapacity = stSort[i];
										stSort[i] = stSort[j];
										stSort[j] = exchangeCapacity;
									}
							}
						}
					}
				}
			}
			break;
		case 6:
			System.out
					.println("输入的时间精度为秒，先比较年，年相同比较月，月相同比较日，日相同比较时，时相同比较分，分相同比较秒");
			for (int i = 0; i < stSort.length - 1; i++) {
				for (int j = i; j < stSort.length; j++) {
					int time1 = Integer.parseInt(stSort[i].split(separator)[0]);
					int time2 = Integer.parseInt(stSort[j].split(separator)[0]);
					int time11 = Integer
							.parseInt(stSort[i].split(separator)[1]);
					int time21 = Integer
							.parseInt(stSort[j].split(separator)[1]);
					int time12 = Integer
							.parseInt(stSort[i].split(separator)[2]);
					int time22 = Integer
							.parseInt(stSort[j].split(separator)[2]);
					int time13 = Integer
							.parseInt(stSort[i].split(separator)[3]);
					int time23 = Integer
							.parseInt(stSort[j].split(separator)[3]);
					int time14 = Integer
							.parseInt(stSort[i].split(separator)[4]);
					int time24 = Integer
							.parseInt(stSort[j].split(separator)[4]);
					int time15 = Integer
							.parseInt(stSort[i].split(separator)[5]);
					int time25 = Integer
							.parseInt(stSort[j].split(separator)[5]);
					String exchangeCapacity;
					if (time1 > time2) {
						exchangeCapacity = stSort[i];
						stSort[i] = stSort[j];
						stSort[j] = exchangeCapacity;
					}
					if (time1 == time2) {
						if (time11 > time21) {
							exchangeCapacity = stSort[i];
							stSort[i] = stSort[j];
							stSort[j] = exchangeCapacity;
						}
						if (time11 == time21) {

							if (time12 > time22) {
								exchangeCapacity = stSort[i];
								stSort[i] = stSort[j];
								stSort[j] = exchangeCapacity;
							}
							if (time12 == time22) {

								if (time13 > time23) {
									exchangeCapacity = stSort[i];
									stSort[i] = stSort[j];
									stSort[j] = exchangeCapacity;
								}
								if (time13 == time23) {

									if (time14 > time24) {
										exchangeCapacity = stSort[i];
										stSort[i] = stSort[j];
										stSort[j] = exchangeCapacity;
									}
									if (time14 == time24)
										if (time15 > time25) {
											exchangeCapacity = stSort[i];
											stSort[i] = stSort[j];
											stSort[j] = exchangeCapacity;
										}
								}
							}
						}
					}
				}
			}
			break;

		default:
			break;
		}
	}

	// public String ascend(String year1, String year2) {
	// int year = Integer.parseInt(year1);
	// int year3 = Integer.parseInt(year2);
	// if (year >= year3)
	// return year1;
	// else
	// return year2;
	// }
	public int[] ascendInt() {
		ascend();
		int[] ascendInt = new int[list.size()];
		for (int i = 0; i < ascendInt.length; i++) {
			System.out.println(list.get(i) + "这是list");
			System.out.println(stSort[i] + "这是stSort");
			ascendInt[i] = list.indexOf(stSort[i]);
		}
		return ascendInt;
	}

	public int[] orderInt() {
		order();
		int[] ascendInt = new int[list.size()];
		for (int i = 0; i < ascendInt.length; i++) {
			ascendInt[i] = list.indexOf(stSort[i]);
		}
		return ascendInt;
	}

}
