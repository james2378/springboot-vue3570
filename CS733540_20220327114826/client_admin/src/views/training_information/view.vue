<template>
	<el-main class="bg">
		<el-form ref="form" :model="form" status-icon label-width="120px" v-if="is_view()">
			<el-col v-if="user_group === '管理员' || $check_field('get','name_of_training_subject') || $check_field('add','name_of_training_subject') || $check_field('set','name_of_training_subject')" :xs="24" :sm="12" :lg="8">
				<el-form-item label="培训科目名称" prop="name_of_training_subject">
					<el-input id="name_of_training_subject" v-model="form['name_of_training_subject']" placeholder="请输入培训科目名称"
							  v-if="user_group === '管理员' || (form['training_information_id'] && $check_field('set','name_of_training_subject')) || (!form['training_information_id'] && $check_field('add','name_of_training_subject'))" :disabled="disabledObj['name_of_training_subject_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','name_of_training_subject')">{{form['name_of_training_subject']}}</div>
				</el-form-item>
			</el-col>
			<el-col v-if="user_group === '管理员' || $check_field('get','training_type') || $check_field('add','training_type') || $check_field('set','training_type')" :xs="24" :sm="12" :lg="8">
				<el-form-item label="培训类型" prop="training_type">
					<el-input id="training_type" v-model="form['training_type']" placeholder="请输入培训类型"
							  v-if="user_group === '管理员' || (form['training_information_id'] && $check_field('set','training_type')) || (!form['training_information_id'] && $check_field('add','training_type'))" :disabled="disabledObj['training_type_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','training_type')">{{form['training_type']}}</div>
				</el-form-item>
			</el-col>
			<el-col v-if="user_group === '管理员' || $check_field('get','training_costs') || $check_field('add','training_costs') || $check_field('set','training_costs')" :xs="24" :sm="12" :lg="8">
				<el-form-item label="培训费用" prop="training_costs">
					<el-input id="training_costs" v-model="form['training_costs']" placeholder="请输入培训费用"
							  v-if="user_group === '管理员' || (form['training_information_id'] && $check_field('set','training_costs')) || (!form['training_information_id'] && $check_field('add','training_costs'))" :disabled="disabledObj['training_costs_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','training_costs')">{{form['training_costs']}}</div>
				</el-form-item>
			</el-col>
			<el-col v-if="user_group === '管理员' || $check_field('get','source_of_teachers') || $check_field('add','source_of_teachers') || $check_field('set','source_of_teachers')" :xs="24" :sm="12" :lg="8">
				<el-form-item label="教师来源" prop="source_of_teachers">
					<el-input id="source_of_teachers" v-model="form['source_of_teachers']" placeholder="请输入教师来源"
							  v-if="user_group === '管理员' || (form['training_information_id'] && $check_field('set','source_of_teachers')) || (!form['training_information_id'] && $check_field('add','source_of_teachers'))" :disabled="disabledObj['source_of_teachers_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','source_of_teachers')">{{form['source_of_teachers']}}</div>
				</el-form-item>
			</el-col>
			<el-col v-if="user_group === '管理员' || $check_field('get','host_department') || $check_field('add','host_department') || $check_field('set','host_department')" :xs="24" :sm="12" :lg="8">
				<el-form-item label="主办部门" prop="host_department">
					<el-input id="host_department" v-model="form['host_department']" placeholder="请输入主办部门"
							  v-if="user_group === '管理员' || (form['training_information_id'] && $check_field('set','host_department')) || (!form['training_information_id'] && $check_field('add','host_department'))" :disabled="disabledObj['host_department_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','host_department')">{{form['host_department']}}</div>
				</el-form-item>
			</el-col>
			<el-col v-if="user_group === '管理员' || $check_field('get','training_date') || $check_field('add','training_date') || $check_field('set','training_date')" :xs="24" :sm="12" :lg="8">
				<el-form-item label="培训日期" prop="training_date">
					<el-date-picker :disabled="disabledObj['training_date_isDisabled']" v-if="user_group === '管理员' || (form['training_information_id'] && $check_field('set','training_date')) || (!form['training_information_id'] && $check_field('add','training_date'))" id="training_date"
						v-model="form['training_date']" type="date" placeholder="选择日期">
					</el-date-picker>
					<div v-else-if="$check_field('get','training_date')">{{form['training_date']}}</div>
				</el-form-item>
			</el-col>
			<el-col v-if="user_group === '管理员' || $check_field('get','end_date') || $check_field('add','end_date') || $check_field('set','end_date')" :xs="24" :sm="12" :lg="8">
				<el-form-item label="结束日期" prop="end_date">
					<el-date-picker :disabled="disabledObj['end_date_isDisabled']" v-if="user_group === '管理员' || (form['training_information_id'] && $check_field('set','end_date')) || (!form['training_information_id'] && $check_field('add','end_date'))" id="end_date"
						v-model="form['end_date']" type="date" placeholder="选择日期">
					</el-date-picker>
					<div v-else-if="$check_field('get','end_date')">{{form['end_date']}}</div>
				</el-form-item>
			</el-col>
			<el-col v-if="user_group === '管理员' || $check_field('get','training_cover') || $check_field('add','training_cover') || $check_field('set','training_cover')" :xs="24" :sm="12" :lg="8">
				<el-form-item label="培训封面" prop="training_cover">
					<el-upload :disabled="disabledObj['training_cover_isDisabled']" id="training_cover" class="avatar-uploader" drag
						accept="image/gif, image/jpeg, image/png, image/jpg" action="" :http-request="upload_training_cover"
						:show-file-list="false" v-if="user_group === '管理员' || (form['training_information_id'] && $check_field('set','training_cover')) || (!form['training_information_id'] && $check_field('add','training_cover'))">
						<img v-if="form['training_cover']" :src="$fullUrl(form['training_cover'])" class="avatar">
						<i v-else class="el-icon-plus avatar-uploader-icon"></i>
					</el-upload>
					<el-image v-else-if="$check_field('get','training_cover')" style="width: 100px; height: 100px"
						:src="$fullUrl(form['training_cover'])" :preview-src-list="[$fullUrl(form['training_cover'])]">
						<div slot="error" class="image-slot">
							<img src="../../../public/img/error.png" style="width: 90px; height: 90px" />
						</div>
					</el-image>
				</el-form-item>
			</el-col>
			<el-col v-if="user_group === '管理员' || $check_field('get','remarks') || $check_field('add','remarks') || $check_field('set','remarks')" :xs="24" :sm="12" :lg="8">
				<el-form-item label="备注" prop="remarks">
					<el-input id="remarks" v-model="form['remarks']" placeholder="请输入备注"
							  v-if="user_group === '管理员' || (form['training_information_id'] && $check_field('set','remarks')) || (!form['training_information_id'] && $check_field('add','remarks'))" :disabled="disabledObj['remarks_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','remarks')">{{form['remarks']}}</div>
				</el-form-item>
			</el-col>
			<el-col v-if="user_group === '管理员' || $check_field('get','trainees') || $check_field('add','trainees') || $check_field('set','trainees')" :xs="24" :sm="12" :lg="8">
				<el-form-item label="参训员工" prop="trainees">
					<el-input type="textarea" id="trainees" v-model="form['trainees']" placeholder="请输入参训员工"
						v-if="user_group === '管理员' || (form['training_information_id'] && $check_field('set','trainees')) || (!form['training_information_id'] && $check_field('add','trainees'))" :disabled="disabledObj['trainees_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','trainees')">{{form['trainees']}}</div>
				</el-form-item>
			</el-col>
			<el-col v-if="user_group === '管理员' || $check_field('get','training_details') || $check_field('add','training_details') || $check_field('set','training_details')" :xs="24" :sm="12" :lg="8">
				<el-form-item label="培训详情" prop="training_details">
					<el-input type="textarea" id="training_details" v-model="form['training_details']" placeholder="请输入培训详情"
						v-if="user_group === '管理员' || (form['training_information_id'] && $check_field('set','training_details')) || (!form['training_information_id'] && $check_field('add','training_details'))" :disabled="disabledObj['training_details_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','training_details')">{{form['training_details']}}</div>
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
				field: "training_information_id",
				url_add: "~/api/training_information/add?",
				url_set: "~/api/training_information/set?",
				url_get_obj: "~/api/training_information/get_obj?",
				url_upload: "~/api/training_information/upload?",

				query: {
					"training_information_id": 0,
				},

				form: {
					"name_of_training_subject":'', // 培训科目名称
					"training_type":'', // 培训类型
					"training_costs":'', // 培训费用
					"source_of_teachers":'', // 教师来源
					"host_department":'', // 主办部门
					"training_date":'', // 培训日期
					"end_date":'', // 结束日期
					"training_cover":'', // 培训封面
					"remarks":'', // 备注
					"trainees":'', // 参训员工
					"training_details":'', // 培训详情
					"training_information_id": 0, // ID

				},
				disabledObj:{
					"name_of_training_subject_isDisabled": false,
					"training_type_isDisabled": false,
					"training_costs_isDisabled": false,
					"source_of_teachers_isDisabled": false,
					"host_department_isDisabled": false,
					"training_date_isDisabled": false,
					"end_date_isDisabled": false,
					"training_cover_isDisabled": false,
					"remarks_isDisabled": false,
					"trainees_isDisabled": false,
					"training_details_isDisabled": false,
				},

			}
		},
		methods: {
			/**
			 * 上传培训封面
			 * @param {Object} param图片参数
			 */
			upload_training_cover(param){
				this.uploadFile(param.file, "training_cover");
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
        if (this.form["training_date"].indexOf("-")===-1){
          this.form["training_date"] = this.$toTime(parseInt(this.form["training_date"]),"yyyy-MM-dd")
        }
        if (this.form["end_date"].indexOf("-")===-1){
          this.form["end_date"] = this.$toTime(parseInt(this.form["end_date"]),"yyyy-MM-dd")
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
				if(parseInt(this.form["training_date"]) > 9999){
					this.form["training_date"] = this.$toTime(parseInt(this.form["training_date"]),"yyyy-MM-dd")
				}
				if(parseInt(this.form["end_date"]) > 9999){
					this.form["end_date"] = this.$toTime(parseInt(this.form["end_date"]),"yyyy-MM-dd")
				}

			},

			is_view(){
				var bl = this.user_group == "管理员";

				if(!bl){
					bl = this.$check_action('/training_information/table','add');
					console.log(bl ? "你有表格添加权限视作有添加权限" : "你没有表格添加权限");
				}
				if(!bl){
					bl = this.$check_action('/training_information/table','set');
					console.log(bl ? "你有表格添加权限视作有修改权限" : "你没有表格修改权限");
				}
				if(!bl){
					bl = this.$check_action('/training_information/view','add');
					console.log(bl ? "你有视图添加权限视作有添加权限" : "你没有视图添加权限");
				}
				if(!bl){
					bl = this.$check_action('/training_information/view','set');
					console.log(bl ? "你有视图修改权限视作有修改权限" : "你没有视图修改权限");
				}
				if(!bl){
					bl = this.$check_action('/training_information/view','get');
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
