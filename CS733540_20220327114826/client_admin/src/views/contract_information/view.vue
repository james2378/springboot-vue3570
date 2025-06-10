<template>
	<el-main class="bg">
		<el-form ref="form" :model="form" status-icon label-width="120px" v-if="is_view()">
			<el-col v-if="user_group === '管理员' || $check_field('get','staff') || $check_field('add','staff') || $check_field('set','staff')" :xs="24" :sm="12" :lg="8">
				<el-form-item label="员工" prop="staff">
						<div v-if="user_group !== '管理员'">
							{{ get_user_session_staff(form['staff']) }}
							<!--<el-input id="business_name" v-model="form['staff']" placeholder="请输入员工"-->
							<!--v-if="user_group === '管理员' || (form['contract_information_id'] && $check_field('set','staff')) || (!form['contract_information_id'] && $check_field('add','staff'))" :disabled="disabledObj['staff_isDisabled']"></el-input>-->
							<!--<div v-else-if="$check_field('get','staff')">{{form['staff']}}</div>-->
							<el-select v-if="user_group === '管理员' || (form['contract_information_id'] && $check_field('set','staff')) || (!form['contract_information_id'] && $check_field('add','staff'))" id="staff" v-model="form['staff']" :disabled="disabledObj['staff_isDisabled']">
								<el-option v-for="o in list_user_staff" :key="o['username']" :label="o['nickname'] + '-' + o['username']"
										   :value="o['user_id']">
								</el-option>
							</el-select>
							<el-select v-else-if="$check_field('get','staff')" id="staff" v-model="form['staff']" :disabled="true">
								<el-option v-for="o in list_user_staff" :key="o['username']" :label="o['nickname'] + '-' + o['username']"
										   :value="o['user_id']">
								</el-option>
							</el-select>
						</div>
						<el-select v-else id="staff" v-model="form['staff']" :disabled="disabledObj['staff_isDisabled']">
							<el-option v-for="o in list_user_staff" :key="o['username']" :label="o['nickname'] + '-' + o['username']"
									   :value="o['user_id']">
							</el-option>
						</el-select>
				</el-form-item>
			</el-col>
			<el-col v-if="user_group === '管理员' || $check_field('get','employee_number') || $check_field('add','employee_number') || $check_field('set','employee_number')" :xs="24" :sm="12" :lg="8">
				<el-form-item label="员工编号" prop="employee_number">
					<el-input id="employee_number" v-model="form['employee_number']" placeholder="请输入员工编号"
							  v-if="user_group === '管理员' || (form['contract_information_id'] && $check_field('set','employee_number')) || (!form['contract_information_id'] && $check_field('add','employee_number'))" :disabled="disabledObj['employee_number_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','employee_number')">{{form['employee_number']}}</div>
				</el-form-item>
			</el-col>
			<el-col v-if="user_group === '管理员' || $check_field('get','full_name') || $check_field('add','full_name') || $check_field('set','full_name')" :xs="24" :sm="12" :lg="8">
				<el-form-item label="姓名" prop="full_name">
					<el-input id="full_name" v-model="form['full_name']" placeholder="请输入姓名"
							  v-if="user_group === '管理员' || (form['contract_information_id'] && $check_field('set','full_name')) || (!form['contract_information_id'] && $check_field('add','full_name'))" :disabled="disabledObj['full_name_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','full_name')">{{form['full_name']}}</div>
				</el-form-item>
			</el-col>
			<el-col v-if="user_group === '管理员' || $check_field('get','department') || $check_field('add','department') || $check_field('set','department')" :xs="24" :sm="12" :lg="8">
				<el-form-item label="部门" prop="department">
					<el-input id="department" v-model="form['department']" placeholder="请输入部门"
							  v-if="user_group === '管理员' || (form['contract_information_id'] && $check_field('set','department')) || (!form['contract_information_id'] && $check_field('add','department'))" :disabled="disabledObj['department_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','department')">{{form['department']}}</div>
				</el-form-item>
			</el-col>
			<el-col v-if="user_group === '管理员' || $check_field('get','post') || $check_field('add','post') || $check_field('set','post')" :xs="24" :sm="12" :lg="8">
				<el-form-item label="职务" prop="post">
					<el-input id="post" v-model="form['post']" placeholder="请输入职务"
							  v-if="user_group === '管理员' || (form['contract_information_id'] && $check_field('set','post')) || (!form['contract_information_id'] && $check_field('add','post'))" :disabled="disabledObj['post_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','post')">{{form['post']}}</div>
				</el-form-item>
			</el-col>
			<el-col v-if="user_group === '管理员' || $check_field('get','contract_signing_date') || $check_field('add','contract_signing_date') || $check_field('set','contract_signing_date')" :xs="24" :sm="12" :lg="8">
				<el-form-item label="合同签订日期" prop="contract_signing_date">
					<el-date-picker :disabled="disabledObj['contract_signing_date_isDisabled']" v-if="user_group === '管理员' || (form['contract_information_id'] && $check_field('set','contract_signing_date')) || (!form['contract_information_id'] && $check_field('add','contract_signing_date'))" id="contract_signing_date"
						v-model="form['contract_signing_date']" type="date" placeholder="选择日期">
					</el-date-picker>
					<div v-else-if="$check_field('get','contract_signing_date')">{{form['contract_signing_date']}}</div>
				</el-form-item>
			</el-col>
			<el-col v-if="user_group === '管理员' || $check_field('get','contract_end_date') || $check_field('add','contract_end_date') || $check_field('set','contract_end_date')" :xs="24" :sm="12" :lg="8">
				<el-form-item label="合同结束日期" prop="contract_end_date">
					<el-date-picker :disabled="disabledObj['contract_end_date_isDisabled']" v-if="user_group === '管理员' || (form['contract_information_id'] && $check_field('set','contract_end_date')) || (!form['contract_information_id'] && $check_field('add','contract_end_date'))" id="contract_end_date"
						v-model="form['contract_end_date']" type="date" placeholder="选择日期">
					</el-date-picker>
					<div v-else-if="$check_field('get','contract_end_date')">{{form['contract_end_date']}}</div>
				</el-form-item>
			</el-col>
			<el-col v-if="user_group === '管理员' || $check_field('get','appendices_of_a_contract') || $check_field('add','appendices_of_a_contract') || $check_field('set','appendices_of_a_contract')" :xs="24" :sm="12" :lg="8">
				<el-form-item label="合同附件" prop="appendices_of_a_contract">
					<div v-if="disabledObj['appendices_of_a_contract_isDisabled']">
						<div v-if="$check_field('get','appendices_of_a_contract')">
							<el-button type="primary" @click="$download($fullUrl(form['appendices_of_a_contract']),form['appendices_of_a_contract'])">下载<i
									class="el-icon-download el-icon--right"></i></el-button>
						</div>
					</div>
					<div v-else>
						<el-upload v-if="user_group === '管理员' || (form['contract_information_id'] && $check_field('set','appendices_of_a_contract')) || (!form['contract_information_id'] && $check_field('add','appendices_of_a_contract'))" class="upload-demo" drag
								   action="" style="max-width: 300px;width: 100%;" :http-request="upload_appendices_of_a_contract" :limit="1" accept="">
							<i class="el-icon-upload"></i>
							<div class="el-upload__text">将文件拖到此处，或<em>点击上传</em></div>
						</el-upload>
						<div v-else-if="$check_field('get','appendices_of_a_contract')">
							<el-button type="primary" @click="$download($fullUrl(form['appendices_of_a_contract']),form['appendices_of_a_contract'])">下载<i
									class="el-icon-download el-icon--right"></i></el-button>
						</div>
					</div>
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
				field: "contract_information_id",
				url_add: "~/api/contract_information/add?",
				url_set: "~/api/contract_information/set?",
				url_get_obj: "~/api/contract_information/get_obj?",
				url_upload: "~/api/contract_information/upload?",

				query: {
					"contract_information_id": 0,
				},

				form: {
					"staff": 0, // 员工
					"employee_number":'', // 员工编号
					"full_name":'', // 姓名
					"department":'', // 部门
					"post":'', // 职务
					"contract_signing_date":'', // 合同签订日期
					"contract_end_date":'', // 合同结束日期
					"appendices_of_a_contract":'', // 合同附件
					"contract_information_id": 0, // ID

				},
				disabledObj:{
					"staff_isDisabled": false,
					"employee_number_isDisabled": false,
					"full_name_isDisabled": false,
					"department_isDisabled": false,
					"post_isDisabled": false,
					"contract_signing_date_isDisabled": false,
					"contract_end_date_isDisabled": false,
					"appendices_of_a_contract_isDisabled": false,
				},
				// 用户列表
				list_user_staff: [],
				// 用户组
				group_user_staff: "",

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
			/**
			 * 获取员工用户用户组
			 */
			async get_group_user_staff() {
				this.form["staff"] = this.user.user_id;
				var json = await this.$get("~/api/user_group/get_obj?name=员工用户");
				if(json.result && json.result.obj){
					this.group_user_staff = json.result.obj;
				}
				else if(json.error){
					console.error(json.error);
				}
			},
			get_user_session_staff(id){
				var _this = this;
				var user_id = {"user_id":id}
				var url = "~/api/"+_this.group_user_staff.source_table+"/get_obj?"
				this.$get(url, user_id, function(res) {
					if (res.result && res.result.obj) {
						var arr = []
						for (let key in res.result.obj) {
							arr.push(key)
						}
						var arrForm = []
						for (let key in _this.form) {
							arrForm.push(key)
						}
						for (var i=0;i<arr.length;i++){
							for (var j=0;j<arrForm.length;j++){
								if (arr[i]===arrForm[j]){
									if (arr[i]!=="staff") {
										_this.form[arrForm[j]] = res.result.obj[arr[i]]
										_this.disabledObj[arrForm[j] + '_isDisabled'] = true
										break;
									}else {
										_this.disabledObj[arrForm[j] + '_isDisabled'] = true
									}
								}
							}
						}
					}
				});
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
			 * 上传合同附件
			 * @param {Object} param文件参数
			 */
			upload_appendices_of_a_contract(param){
				this.uploadFile(param.file, "appendices_of_a_contract");
			},

			/**
			 * 获取对象之前
			 * @param {Object} param
			 */
			get_obj_before(param) {
				var form = "";
				/**
				* 请求列表前
				* @param {Object} param
				*/
				var user_group = this.user.user_group;
				if (user_group !== "管理员") {
					switch (user_group) {
						case "员工":
							if(param["staff"] > 0){
								param["staff"] = this.user.user_id;
							}
							break;
					}
				}
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
        if (this.form["contract_signing_date"].indexOf("-")===-1){
          this.form["contract_signing_date"] = this.$toTime(parseInt(this.form["contract_signing_date"]),"yyyy-MM-dd")
        }
        if (this.form["contract_end_date"].indexOf("-")===-1){
          this.form["contract_end_date"] = this.$toTime(parseInt(this.form["contract_end_date"]),"yyyy-MM-dd")
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
				if(parseInt(this.form["contract_signing_date"]) > 9999){
					this.form["contract_signing_date"] = this.$toTime(parseInt(this.form["contract_signing_date"]),"yyyy-MM-dd")
				}
				if(parseInt(this.form["contract_end_date"]) > 9999){
					this.form["contract_end_date"] = this.$toTime(parseInt(this.form["contract_end_date"]),"yyyy-MM-dd")
				}

			},

			is_view(){
				var bl = this.user_group == "管理员";

				if(!bl){
					bl = this.$check_action('/contract_information/table','add');
					console.log(bl ? "你有表格添加权限视作有添加权限" : "你没有表格添加权限");
				}
				if(!bl){
					bl = this.$check_action('/contract_information/table','set');
					console.log(bl ? "你有表格添加权限视作有修改权限" : "你没有表格修改权限");
				}
				if(!bl){
					bl = this.$check_action('/contract_information/view','add');
					console.log(bl ? "你有视图添加权限视作有添加权限" : "你没有视图添加权限");
				}
				if(!bl){
					bl = this.$check_action('/contract_information/view','set');
					console.log(bl ? "你有视图修改权限视作有修改权限" : "你没有视图修改权限");
				}
				if(!bl){
					bl = this.$check_action('/contract_information/view','get');
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
			this.get_group_user_staff();
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
