<template>
	<div class="diy_home diy_list diy_training_information" id="diy_training_information_list">
		<!-- 列表 -->
		<div class="diy_view_list list list-x" v-if="show">
			<router-link class="diy_card goods diy_list_box_wrap" v-for="(o, i) in list" :key="i"
				:to="'/training_information/details?training_information_id=' + o['training_information_id']">
				<!-- 图片 -->
				<div class="diy_list_img_box" v-if="imgList.length" >
					<div class="diy_row" v-for="(item,index) in imgList" :key="item+index" v-show="$check_field('get',item.name,'/training_information/details') && +item.is_img_list">
						<div class="diy_title diy_list_img_title">
							<span>{{item.title}}:</span>
						</div>
						<div class="diy_field diy_img">
							<img :src="$fullUrl(o[item.name])" style="width:100%;height:100%" />
						</div>
					</div>
				</div>
				<!-- 内容 -->
				<div class="diy_list_item_box">
					<div class="diy_list_item_content" v-for="(item,index) in showItemList" :key="item+index">
						<div class="diy_row" :class="{[item.name]:true}" v-if="$check_field('get',item.name,'/training_information/details') && +item.is_img_list">
							<div class="diy_title">
								<span>{{item.title}}:</span>
							</div>
							<div class="diy_field diy_text">
								<span v-if="item.type == 'UID'" v-text="get_user_name(o[item.name])"></span>
								<span v-else-if="item.type == '日期'" v-text="$toTime(o[item.name],'yyyy-MM-dd')"></span>
								<span v-else-if="item.type == '时间'" v-text="$toTime(o[item.name],'hh:mm:ss')"></span>
								<span v-else-if="item.type == '日长'" v-text="$toTime(o[item.name],'yyyy-MM-dd hh:mm:ss')"></span>
								<span v-else v-text="o[item.name]"></span>
							</div>
						</div>
					</div>
				</div>
			</router-link>
		</div>
		<!-- 表格 -->
		<div class="diy_view_table" v-else>
			<table class="diy_table">
				<tr class="diy_row">
					<th class="diy_title" v-if="$check_field('get','name_of_training_subject')">培训科目名称
					</th>
					<th class="diy_title" v-if="$check_field('get','training_type')">培训类型
					</th>
					<th class="diy_title" v-if="$check_field('get','training_costs')">培训费用
					</th>
					<th class="diy_title" v-if="$check_field('get','source_of_teachers')">教师来源
					</th>
					<th class="diy_title" v-if="$check_field('get','host_department')">主办部门
					</th>
					<th class="diy_title" v-if="$check_field('get','training_date')">培训日期
					</th>
					<th class="diy_title" v-if="$check_field('get','end_date')">结束日期
					</th>
					<th class="diy_title" v-if="$check_field('get','training_cover')">培训封面
					</th>
					<th class="diy_title" v-if="$check_field('get','remarks')">备注
					</th>
					<th class="diy_title" v-if="$check_field('get','trainees')">参训员工
					</th>
					<th class="diy_title" v-if="$check_field('get','training_details')">培训详情
					</th>
				</tr>
				<tr class="diy_row" v-for="(o,i) in list" :key="o+i">
					<td class="diy_field diy_text" v-if="$check_field('get','name_of_training_subject')">
						<span>
							{{ o["name_of_training_subject"] }}
						</span>
					</td>
					<td class="diy_field diy_text" v-if="$check_field('get','training_type')">
						<span>
							{{ o["training_type"] }}
						</span>
					</td>
					<td class="diy_field diy_text" v-if="$check_field('get','training_costs')">
						<span>
							{{ o["training_costs"] }}
						</span>
					</td>
					<td class="diy_field diy_text" v-if="$check_field('get','source_of_teachers')">
						<span>
							{{ o["source_of_teachers"] }}
						</span>
					</td>
					<td class="diy_field diy_text" v-if="$check_field('get','host_department')">
						<span>
							{{ o["host_department"] }}
						</span>
					</td>
					<td class="diy_field diy_date" v-if="$check_field('get','training_date')">
						<span>
							{{ $toTime(o["training_date"] ,"yyyy-MM-dd") }}
						</span>
					</td>
					<td class="diy_field diy_date" v-if="$check_field('get','end_date')">
						<span>
							{{ $toTime(o["end_date"] ,"yyyy-MM-dd") }}
						</span>
					</td>
					<td class="diy_field" v-if="$check_field('get','training_cover')">
						<img class="diy_img" :src="o['training_cover']" />
					</td>
					<td class="diy_field diy_text" v-if="$check_field('get','remarks')">
						<span>
							{{ o["remarks"] }}
						</span>
					</td>
					<td class="diy_field diy_text" v-if="$check_field('get','trainees')">
						<span>
							{{ o["trainees"] }}
						</span>
					</td>
					<td class="diy_field diy_text" v-if="$check_field('get','training_details')">
						<span>
							{{ o["training_details"] }}
						</span>
					</td>
				</tr>
			</table>
		</div>
	</div>
</template>

<script>
	export default {
		props: {
			list: {
				type: Array,
				default: function() {
					return [];
				},
			},
			show: {
				type: Boolean,
				default: function(){
					return true;
				}
			}
		},
		data() {
			return {
						imgList: [
						{
							title: "培训封面",
							name: "training_cover",
							type: "图片",
							is_img_list: "1"
						},
						],
						itemList: [
								{
									title: "培训科目名称",
									name: "name_of_training_subject",
									type: "文本",
									is_img_list: "1"
								},
								{
									title: "培训类型",
									name: "training_type",
									type: "文本",
									is_img_list: "1"
								},
								{
									title: "培训费用",
									name: "training_costs",
									type: "文本",
									is_img_list: "1"
								},
								{
									title: "教师来源",
									name: "source_of_teachers",
									type: "文本",
									is_img_list: "0"
								},
								{
									title: "主办部门",
									name: "host_department",
									type: "文本",
									is_img_list: "1"
								},
								{
									title: "培训日期",
									name: "training_date",
									type: "日期",
									is_img_list: "0"
								},
								{
									title: "结束日期",
									name: "end_date",
									type: "日期",
									is_img_list: "0"
								},
								{
									title: "备注",
									name: "remarks",
									type: "文本",
									is_img_list: "0"
								},
						],
						richList: [
								{
									title: "参训员工",
									name: "trainees",
									type: "多文本"
								},
								{
									title: "培训详情",
									name: "training_details",
									type: "多文本"
								},
						],
			};
		},
		methods: {
		},
		created() {
		},
		computed:{
			showItemList(){
				let arr = [];
				let _type = ["视频","音频","文件"];
				this.itemList.forEach(item => {
					if(_type.indexOf(item.type) === -1 && !!+item.is_img_list){
						arr.push(item)
					}
				})
				return arr.slice(0,4);
			}
		}
	};
</script>

<style scoped>
	.media {
		display: flex;
		flex-direction: column;
		justify-content: space-between;
		flex-basis: 75%;
		min-height: 10rem;
	}

	.goods {
		display: flex;
		width: calc(25% - 1rem);
		margin: 0.5rem;
		padding: 0.5rem;
		flex-direction: column;
		justify-content: space-between;
		background-color: white;
		border-radius: 0.5rem;
	}

	.goods:hover {
		border: 0.2rem solid #909399;
		box-shadow: 0 0.1rem 0.3rem rgba(0, 0, 0, 0.15);
	}

	.goods:hover img {
		filter: blur(1px);
	}

	.price {
		font-size: 1rem;
		margin-right: 3px;
	}

	.price_ago {
		text-decoration: line-through;
		font-size: 0.5rem;
		color: #999;

	}

	.title {
		word-break: break-all;
		overflow: hidden;
		text-overflow: ellipsis;
		white-space: nowrap;
		font-weight: 700;
		padding: .25rem;
	}

	.icon_cart {
		color: #FF5722;
		float: right;
	}

	@media (max-width: 992px) {

		.goods {
			width: calc(33% - 1rem);
			;
		}

	}

	@media (max-width: 768px) {

		.goods {
			width: calc(50% - 1rem);
			;
		}

	}
</style>

