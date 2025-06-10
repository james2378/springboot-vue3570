<template>
	<el-main class="bg">
		<el-form ref="form" :model="form" status-icon label-width="120px" v-if="is_view()">
			<el-col v-if="user_group === '管理员' || $check_field('get','staff') || $check_field('add','staff') || $check_field('set','staff')" :xs="24" :sm="12" :lg="8">
				<el-form-item label="员工" prop="staff">
						<el-select v-if="user_group === '管理员' || (form['reward_and_punishment_information_id'] && $check_field('set','staff')) || (!form['reward_and_punishment_information_id'] && $check_field('add','staff'))" id="staff" v-model="form['staff']" :disabled="disabledObj['staff_isDisabled']">
							<el-option v-for="o in list_user_staff" :key="o['username']" :label="o['nickname'] + '-' + o['username']"
									   :value="o['user_id']">
							</el-option>
						</el-select>
						<el-select v-else-if="$check_field('get','staff')" id="staff" v-model="form['staff']" :disabled="true">
							<el-option v-for="o in list_user_staff" :key="o['username']" :label="o['nickname'] + '-' + o['username']"
									   :value="o['user_id']">
							</el-option>
						</el-select>
				</el-form-item>
			</el-col>
			<el-col v-if="user_group === '管理员' || $check_field('get','employee_number') || $check_field('add','employee_number') || $check_field('set','employee_number')" :xs="24" :sm="12" :lg="8">
				<el-form-item label="员工编号" prop="employee_number">
					<el-input id="employee_number" v-model="form['employee_number']" placeholder="请输入员工编号"
							  v-if="user_group === '管理员' || (form['reward_and_punishment_information_id'] && $check_field('set','employee_number')) || (!form['reward_and_punishment_information_id'] && $check_field('add','employee_number'))" :disabled="disabledObj['employee_number_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','employee_number')">{{form['employee_number']}}</div>
				</el-form-item>
			</el-col>
			<el-col v-if="user_group === '管理员' || $check_field('get','full_name') || $check_field('add','full_name') || $check_field('set','full_name')" :xs="24" :sm="12" :lg="8">
				<el-form-item label="姓名" prop="full_name">
					<el-input id="full_name" v-model="form['full_name']" placeholder="请输入姓名"
							  v-if="user_group === '管理员' || (form['reward_and_punishment_information_id'] && $check_field('set','full_name')) || (!form['reward_and_punishment_information_id'] && $check_field('add','full_name'))" :disabled="disabledObj['full_name_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','full_name')">{{form['full_name']}}</div>
				</el-form-item>
			</el-col>
			<el-col v-if="user_group === '管理员' || $check_field('get','department') || $check_field('add','department') || $check_field('set','department')" :xs="24" :sm="12" :lg="8">
				<el-form-item label="部门" prop="department">
					<el-input id="department" v-model="form['department']" placeholder="请输入部门"
							  v-if="user_group === '管理员' || (form['reward_and_punishment_information_id'] && $check_field('set','department')) || (!form['reward_and_punishment_information_id'] && $check_field('add','department'))" :disabled="disabledObj['department_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','department')">{{form['department']}}</div>
				</el-form-item>
			</el-col>
			<el-col v-if="user_group === '管理员' || $check_field('get','post') || $check_field('add','post') || $check_field('set','post')" :xs="24" :sm="12" :lg="8">
				<el-form-item label="职务" prop="post">
					<el-input id="post" v-model="form['post']" placeholder="请输入职务"
							  v-if="user_group === '管理员' || (form['reward_and_punishment_information_id'] && $check_field('set','post')) || (!form['reward_and_punishment_information_id'] && $check_field('add','post'))" :disabled="disabledObj['post_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','post')">{{form['post']}}</div>
				</el-form-item>
			</el-col>
			<el-col v-if="user_group === '管理员' || $check_field('get','types_of_rewards_and_punishments') || $check_field('add','types_of_rewards_and_punishments') || $check_field('set','types_of_rewards_and_punishments')" :xs="24" :sm="12" :lg="8">
				<el-form-item label="奖罚类型" prop="types_of_rewards_and_punishments">
					<el-select id="types_of_rewards_and_punishments" v-model="form['types_of_rewards_and_punishments']"
						v-if="user_group === '管理员' || (form['reward_and_punishment_information_id'] && $check_field('set','types_of_rewards_and_punishments')) || (!form['reward_and_punishment_information_id'] && $check_field('add','types_of_rewards_and_punishments'))">
						<el-option v-for="o in list_types_of_rewards_and_punishments" :key="o" :label="o" :value="o">
						</el-option>
					</el-select>
					<div v-else-if="$check_field('get','types_of_rewards_and_punishments')">{{form['types_of_rewards_and_punishments']}}</div>
				</el-form-item>
			</el-col>
			<el-col v-if="user_group === '管理员' || $check_field('get','release_date') || $check_field('add','release_date') || $check_field('set','release_date')" :xs="24" :sm="12" :lg="8">
				<el-form-item label="发布日期" prop="release_date">
					<el-date-picker :disabled="disabledObj['release_date_isDisabled']" v-if="user_group === '管理员' || (form['reward_and_punishment_information_id'] && $check_field('set','release_date')) || (!form['reward_and_punishment_information_id'] && $check_field('add','release_date'))" id="release_date"
						v-model="form['release_date']" type="date" placeholder="选择日期">
					</el-date-picker>
					<div v-else-if="$check_field('get','release_date')">{{form['release_date']}}</div>
				</el-form-item>
			</el-col>
			<el-col v-if="user_group === '管理员' || $check_field('get','publisher') || $check_field('add','publisher') || $check_field('set','publisher')" :xs="24" :sm="12" :lg="8">
				<el-form-item label="发布人" prop="publisher">
					<el-input id="publisher" v-model="form['publisher']" placeholder="请输入发布人"
							  v-if="user_group === '管理员' || (form['reward_and_punishment_information_id'] && $check_field('set','publisher')) || (!form['reward_and_punishment_information_id'] && $check_field('add','publisher'))" :disabled="disabledObj['publisher_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','publisher')">{{form['publisher']}}</div>
				</el-form-item>
			</el-col>
			<el-col v-if="user_group === '管理员' || $check_field('get','details_of_rewards_and_penalties') || $check_field('add','details_of_rewards_and_penalties') || $check_field('set','details_of_rewards_and_penalties')" :xs="24" :sm="12" :lg="8">
				<el-form-item label="奖罚详情" prop="details_of_rewards_and_penalties">
					<el-input type="textarea" id="details_of_rewards_and_penalties" v-model="form['details_of_rewards_and_penalties']" placeholder="请输入奖罚详情"
						v-if="user_group === '管理员' || (form['reward_and_punishment_information_id'] && $check_field('set','details_of_rewards_and_penalties')) || (!form['reward_and_punishment_information_id'] && $check_field('add','details_of_rewards_and_penalties'))" :disabled="disabledObj['details_of_rewards_and_penalties_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','details_of_rewards_and_penalties')">{{form['details_of_rewards_and_penalties']}}</div>
				</el-form-item>
			</el-col>
			<el-col :xs="24" :sm="12" :lg="8">
				<el-form-item>
					<el-button type="primary" @click="submit()">提交</el-button>
					<el-button @click="cancel()">取消</el-button>
				</el-form-item>
			</el-col>

		</el-form>
	</el-main>
</template>

<script>
	import mixin from "@/mixins/page.js";

	export default {
		mixins: [mixin],
		data() {
			return {
				field: "reward_and_punishment_information_id",
				url_add: "~/api/reward_and_punishment_information/add?",
				url_set: "~/api/reward_and_punishment_information/set?",
				url_get_obj: "~/api/reward_and_punishment_information/get_obj?",
				url_upload: "~/api/reward_and_punishment_information/upload?",

				query: {
					"reward_and_punishment_information_id": 0,
				},

				form: {
					"staff": 0, // 员工
					"employee_number":'', // 员工编号
					"full_name":'', // 姓名
					"department":'', // 部门
					"post":'', // 职务
					"types_of_rewards_and_punishments":'', // 奖罚类型
					"release_date":'', // 发布日期
					"publisher":'', // 发布人
					"details_of_rewards_and_penalties":'', // 奖罚详情
					"reward_and_punishment_information_id": 0, // ID

				},
				disabledObj:{
					"staff_isDisabled": false,
					"employee_number_isDisabled": false,
					"full_name_isDisabled": false,
					"department_isDisabled": false,
					"post_isDisabled": false,
					"types_of_rewards_and_punishments_isDisabled": false,
					"release_date_isDisabled": false,
					"publisher_isDisabled": false,
					"details_of_rewards_and_penalties_isDisabled": false,
				},
				// 用户列表
				list_user_staff: [],
				//奖罚类型选项列表
				list_types_of_rewards_and_punishments: ['奖励','处罚'],

			}
		},
		methods: {
			/**
			 * 获取员工用户用户列表
			 */
			async get_list_user_staff() {
                // if(this.user_group !== "管理员" && this.form["staff"] === 0) {
                //     this.form["staff"] = this.user.user_id;
                // }
                var json = await this.$get("~/api/user/get_list?user_group=员工用户");
                if(json.result && json.result.list){
                    this.list_user_staff = json.result.list;
                }
                else if(json.error){
                    console.error(json.error);
                }
			},
			get_user_staff(id){
				var obj = this.list_user_staff.getObj({"user_id":id});
				var ret = "";
				if(obj){
					if(obj.nickname){
						ret = obj.nickname;}
					else{
						ret = obj.username;
					}
				}
				return ret;
			},

			/**
			 * 获取对象之前
			 * @param {Object} param
			 */
			get_obj_before(param) {
				var form = "";
				if(this.form && form){
					Object.keys(this.form).forEach(key => {
						Object.keys(form).forEach(dbKey => {
							// if(dbKey === "charging_standard"){
							// 	this.form['charging_rules'] = form[dbKey];
							// 	this.disabledObj['charging_rules_isDisabled'] = true;
							// };
							if(key === dbKey){
								this.disabledObj[key+'_isDisabled'] = true;
							}
						})
					})
				}
        if (this.form["release_date"].indexOf("-")===-1){
          this.form["release_date"] = this.$toTime(parseInt(this.form["release_date"]),"yyyy-MM-dd")
        }
				$.db.del("form");
				return param;
			},

			/**
			 * 获取对象之后
			 * @param {Object} json
			 * @param {Object} func
			 */
			get_obj_after(json, func){
				if(parseInt(this.form["release_date"]) > 9999){
					this.form["release_date"] = this.$toTime(parseInt(this.form["release_date"]),"yyyy-MM-dd")
				}

			},

			is_view(){
				var bl = this.user_group == "管理员";

				if(!bl){
					bl = this.$check_action('/reward_and_punishment_information/table','add');
					console.log(bl ? "你有表格添加权限视作有添加权限" : "你没有表格添加权限");
				}
				if(!bl){
					bl = this.$check_action('/reward_and_punishment_information/table','set');
					console.log(bl ? "你有表格添加权限视作有修改权限" : "你没有表格修改权限");
				}
				if(!bl){
					bl = this.$check_action('/reward_and_punishment_information/view','add');
					console.log(bl ? "你有视图添加权限视作有添加权限" : "你没有视图添加权限");
				}
				if(!bl){
					bl = this.$check_action('/reward_and_punishment_information/view','set');
					console.log(bl ? "你有视图修改权限视作有修改权限" : "你没有视图修改权限");
				}
				if(!bl){
					bl = this.$check_action('/reward_and_punishment_information/view','get');
					console.log(bl ? "你有视图查询权限视作有查询权限" : "你没有视图查询权限");
				}

				console.log(bl ? "具有当前页面的查看权，请注意这不代表你有字段的查看权" : "无权查看当前页，请注意即便有字段查询权限没有页面查询权限也不行");

				return bl;
			},
			/**
			 * 上传文件
			 * @param {Object} param
			 */
			uploadimg(param) {
				this.uploadFile(param.file, "avatar");
			},

		},
		created() {
			this.get_list_user_staff();
		}
	}
</script>

<style>
	.avatar-uploader .el-upload {
		border: 1px dashed #d9d9d9;
		border-radius: 6px;
		cursor: pointer;
		position: relative;
		overflow: hidden;
	}

	.avatar-uploader .el-upload:hover {
		border-color: #409EFF;
	}

	.avatar-uploader-icon {
		font-size: 28px;
		color: #8c939d;
		width: 178px;
		height: 178px;
		line-height: 178px;
		text-align: center;
	}

	.avatar {
		width: 178px;
		height: 178px;
		display: block;
	}
</style>
