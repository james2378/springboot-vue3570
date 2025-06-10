<template>
  <div class="page_search">
	<div class="warp">
	  <div class="container">
		<div class="row">
		  <div class="col-12">
			<div class="card_result_search">
			  <div class="title">搜索结果</div>
				<!-- 文章搜索结果 -->
			  <list_result_search
				:list="result_article"
				title="企业资讯"
				source_table="article"
			  ></list_result_search>
			  <list_result_search
				v-if="$check_action('/contract_information/list', 'get')"
				:list="result_contract_information_employee_number"
				title="合同信息员工编号"
				source_table="contract_information"
			  ></list_result_search>
			  <list_result_search
				v-if="$check_action('/contract_information/list', 'get')"
				:list="result_contract_information_full_name"
				title="合同信息姓名"
				source_table="contract_information"
			  ></list_result_search>
			  <list_result_search
				v-if="$check_action('/contract_information/list', 'get')"
				:list="result_contract_information_department"
				title="合同信息部门"
				source_table="contract_information"
			  ></list_result_search>
			  <list_result_search
				v-if="$check_action('/contract_information/list', 'get')"
				:list="result_contract_information_contract_signing_date"
				title="合同信息合同签订日期"
				source_table="contract_information"
			  ></list_result_search>
			  <list_result_search
				v-if="$check_action('/employee_user/list', 'get')"
				:list="result_employee_user_employee_number"
				title="员工用户员工编号"
				source_table="employee_user"
			  ></list_result_search>
			  <list_result_search
				v-if="$check_action('/employee_user/list', 'get')"
				:list="result_employee_user_full_name"
				title="员工用户姓名"
				source_table="employee_user"
			  ></list_result_search>
			  <list_result_search
				v-if="$check_action('/employee_user/list', 'get')"
				:list="result_employee_user_department"
				title="员工用户部门"
				source_table="employee_user"
			  ></list_result_search>
			  <list_result_search
				v-if="$check_action('/training_information/list', 'get')"
				:list="result_training_information_name_of_training_subject"
				title="培训信息培训科目名称"
				source_table="training_information"
			  ></list_result_search>
			  <list_result_search
				v-if="$check_action('/training_information/list', 'get')"
				:list="result_training_information_training_type"
				title="培训信息培训类型"
				source_table="training_information"
			  ></list_result_search>
			  <list_result_search
				v-if="$check_action('/training_information/list', 'get')"
				:list="result_training_information_training_date"
				title="培训信息培训日期"
				source_table="training_information"
			  ></list_result_search>
			  <list_result_search
				v-if="$check_action('/department_information/list', 'get')"
				:list="result_department_information_department_name"
				title="部门信息部门名称"
				source_table="department_information"
			  ></list_result_search>
			  <list_result_search
				v-if="$check_action('/attendance_information/list', 'get')"
				:list="result_attendance_information_employee_number"
				title="考勤信息员工编号"
				source_table="attendance_information"
			  ></list_result_search>
			  <list_result_search
				v-if="$check_action('/attendance_information/list', 'get')"
				:list="result_attendance_information_full_name"
				title="考勤信息姓名"
				source_table="attendance_information"
			  ></list_result_search>
			  <list_result_search
				v-if="$check_action('/attendance_information/list', 'get')"
				:list="result_attendance_information_department"
				title="考勤信息部门"
				source_table="attendance_information"
			  ></list_result_search>
			  <list_result_search
				v-if="$check_action('/salary_information/list', 'get')"
				:list="result_salary_information_employee_number"
				title="薪资信息员工编号"
				source_table="salary_information"
			  ></list_result_search>
			  <list_result_search
				v-if="$check_action('/salary_information/list', 'get')"
				:list="result_salary_information_full_name"
				title="薪资信息姓名"
				source_table="salary_information"
			  ></list_result_search>
			  <list_result_search
				v-if="$check_action('/salary_information/list', 'get')"
				:list="result_salary_information_department"
				title="薪资信息部门"
				source_table="salary_information"
			  ></list_result_search>
			  <list_result_search
				v-if="$check_action('/resignation_information/list', 'get')"
				:list="result_resignation_information_employee_number"
				title="离职信息员工编号"
				source_table="resignation_information"
			  ></list_result_search>
			  <list_result_search
				v-if="$check_action('/resignation_information/list', 'get')"
				:list="result_resignation_information_full_name"
				title="离职信息姓名"
				source_table="resignation_information"
			  ></list_result_search>
			  <list_result_search
				v-if="$check_action('/resignation_information/list', 'get')"
				:list="result_resignation_information_department"
				title="离职信息部门"
				source_table="resignation_information"
			  ></list_result_search>
			  <list_result_search
				v-if="$check_action('/reward_and_punishment_information/list', 'get')"
				:list="result_reward_and_punishment_information_employee_number"
				title="奖罚信息员工编号"
				source_table="reward_and_punishment_information"
			  ></list_result_search>
			  <list_result_search
				v-if="$check_action('/reward_and_punishment_information/list', 'get')"
				:list="result_reward_and_punishment_information_full_name"
				title="奖罚信息姓名"
				source_table="reward_and_punishment_information"
			  ></list_result_search>
			  <list_result_search
				v-if="$check_action('/reward_and_punishment_information/list', 'get')"
				:list="result_reward_and_punishment_information_department"
				title="奖罚信息部门"
				source_table="reward_and_punishment_information"
			  ></list_result_search>
			  <list_result_search
				v-if="$check_action('/reward_and_punishment_information/list', 'get')"
				:list="result_reward_and_punishment_information_types_of_rewards_and_punishments"
				title="奖罚信息奖罚类型"
				source_table="reward_and_punishment_information"
			  ></list_result_search>
			</div>
		  </div>
		</div>
	  </div>
	</div>
  </div>
</template>

<script>
import mixin from "../../mixins/page.js";
import list_result_search from "../../components/diy/list_result_search.vue";

export default {
  mixins: [mixin],
  data() {
	return {
	  "query": {
		word: "",
	  },
	  "result_article": [],
			"result_contract_information_employee_number":[],
			"result_contract_information_full_name":[],
			"result_contract_information_department":[],
			"result_contract_information_contract_signing_date":[],
			"result_employee_user_employee_number":[],
			"result_employee_user_full_name":[],
			"result_employee_user_department":[],
			"result_training_information_name_of_training_subject":[],
			"result_training_information_training_type":[],
			"result_training_information_training_date":[],
			"result_department_information_department_name":[],
			"result_attendance_information_employee_number":[],
			"result_attendance_information_full_name":[],
			"result_attendance_information_department":[],
			"result_salary_information_employee_number":[],
			"result_salary_information_full_name":[],
			"result_salary_information_department":[],
			"result_resignation_information_employee_number":[],
			"result_resignation_information_full_name":[],
			"result_resignation_information_department":[],
			"result_reward_and_punishment_information_employee_number":[],
			"result_reward_and_punishment_information_full_name":[],
			"result_reward_and_punishment_information_department":[],
			"result_reward_and_punishment_information_types_of_rewards_and_punishments":[],
	};
  },
  methods: {
	/**
	 * 获取文章
	 */
	get_article() {
	  this.$get("~/api/article/get_list?like=0", { page: 1, size: 10, title: this.query.word }, (json) => {
		if (json.result) {
		  this.result_article = json.result.list;
		}
	  });
	},
	/**
	 * 获取employee_number
	 */
	get_contract_information_employee_number(){
		this.$get("~/api/contract_information/get_list?like=0", { page: 1, size: 10, "employee_number": this.query.word }, (json) => {
		  if (json.result) {
			var result_contract_information_employee_number = json.result.list;
			result_contract_information_employee_number.map(o => o.title = o['employee_number'])
	  			this.result_contract_information_employee_number = result_contract_information_employee_number
		 	}
		});
	},
	/**
	 * 获取full_name
	 */
	get_contract_information_full_name(){
		this.$get("~/api/contract_information/get_list?like=0", { page: 1, size: 10, "full_name": this.query.word }, (json) => {
		  if (json.result) {
			var result_contract_information_full_name = json.result.list;
			result_contract_information_full_name.map(o => o.title = o['full_name'])
	  			this.result_contract_information_full_name = result_contract_information_full_name
		 	}
		});
	},
	/**
	 * 获取department
	 */
	get_contract_information_department(){
		this.$get("~/api/contract_information/get_list?like=0", { page: 1, size: 10, "department": this.query.word }, (json) => {
		  if (json.result) {
			var result_contract_information_department = json.result.list;
			result_contract_information_department.map(o => o.title = o['department'])
	  			this.result_contract_information_department = result_contract_information_department
		 	}
		});
	},
	/**
	 * 获取contract_signing_date
	 */
	get_contract_information_contract_signing_date(){
		this.$get("~/api/contract_information/get_list?like=0", { page: 1, size: 10, "contract_signing_date": this.query.word }, (json) => {
		  if (json.result) {
			var result_contract_information_contract_signing_date = json.result.list;
			result_contract_information_contract_signing_date.map(o => o.title = o['contract_signing_date'])
	  			this.result_contract_information_contract_signing_date = result_contract_information_contract_signing_date
		 	}
		});
	},
	/**
	 * 获取employee_number
	 */
	get_employee_user_employee_number(){
		this.$get("~/api/employee_user/get_list?like=0", { page: 1, size: 10, "employee_number": this.query.word }, (json) => {
		  if (json.result) {
			var result_employee_user_employee_number = json.result.list;
			result_employee_user_employee_number.map(o => o.title = o['employee_number'])
	  			this.result_employee_user_employee_number = result_employee_user_employee_number
		 	}
		});
	},
	/**
	 * 获取full_name
	 */
	get_employee_user_full_name(){
		this.$get("~/api/employee_user/get_list?like=0", { page: 1, size: 10, "full_name": this.query.word }, (json) => {
		  if (json.result) {
			var result_employee_user_full_name = json.result.list;
			result_employee_user_full_name.map(o => o.title = o['full_name'])
	  			this.result_employee_user_full_name = result_employee_user_full_name
		 	}
		});
	},
	/**
	 * 获取department
	 */
	get_employee_user_department(){
		this.$get("~/api/employee_user/get_list?like=0", { page: 1, size: 10, "department": this.query.word }, (json) => {
		  if (json.result) {
			var result_employee_user_department = json.result.list;
			result_employee_user_department.map(o => o.title = o['department'])
	  			this.result_employee_user_department = result_employee_user_department
		 	}
		});
	},
	/**
	 * 获取name_of_training_subject
	 */
	get_training_information_name_of_training_subject(){
		this.$get("~/api/training_information/get_list?like=0", { page: 1, size: 10, "name_of_training_subject": this.query.word }, (json) => {
		  if (json.result) {
			var result_training_information_name_of_training_subject = json.result.list;
			result_training_information_name_of_training_subject.map(o => o.title = o['name_of_training_subject'])
	  			this.result_training_information_name_of_training_subject = result_training_information_name_of_training_subject
		 	}
		});
	},
	/**
	 * 获取training_type
	 */
	get_training_information_training_type(){
		this.$get("~/api/training_information/get_list?like=0", { page: 1, size: 10, "training_type": this.query.word }, (json) => {
		  if (json.result) {
			var result_training_information_training_type = json.result.list;
			result_training_information_training_type.map(o => o.title = o['training_type'])
	  			this.result_training_information_training_type = result_training_information_training_type
		 	}
		});
	},
	/**
	 * 获取training_date
	 */
	get_training_information_training_date(){
		this.$get("~/api/training_information/get_list?like=0", { page: 1, size: 10, "training_date": this.query.word }, (json) => {
		  if (json.result) {
			var result_training_information_training_date = json.result.list;
			result_training_information_training_date.map(o => o.title = o['training_date'])
	  			this.result_training_information_training_date = result_training_information_training_date
		 	}
		});
	},
	/**
	 * 获取department_name
	 */
	get_department_information_department_name(){
		this.$get("~/api/department_information/get_list?like=0", { page: 1, size: 10, "department_name": this.query.word }, (json) => {
		  if (json.result) {
			var result_department_information_department_name = json.result.list;
			result_department_information_department_name.map(o => o.title = o['department_name'])
	  			this.result_department_information_department_name = result_department_information_department_name
		 	}
		});
	},
	/**
	 * 获取employee_number
	 */
	get_attendance_information_employee_number(){
		this.$get("~/api/attendance_information/get_list?like=0", { page: 1, size: 10, "employee_number": this.query.word }, (json) => {
		  if (json.result) {
			var result_attendance_information_employee_number = json.result.list;
			result_attendance_information_employee_number.map(o => o.title = o['employee_number'])
	  			this.result_attendance_information_employee_number = result_attendance_information_employee_number
		 	}
		});
	},
	/**
	 * 获取full_name
	 */
	get_attendance_information_full_name(){
		this.$get("~/api/attendance_information/get_list?like=0", { page: 1, size: 10, "full_name": this.query.word }, (json) => {
		  if (json.result) {
			var result_attendance_information_full_name = json.result.list;
			result_attendance_information_full_name.map(o => o.title = o['full_name'])
	  			this.result_attendance_information_full_name = result_attendance_information_full_name
		 	}
		});
	},
	/**
	 * 获取department
	 */
	get_attendance_information_department(){
		this.$get("~/api/attendance_information/get_list?like=0", { page: 1, size: 10, "department": this.query.word }, (json) => {
		  if (json.result) {
			var result_attendance_information_department = json.result.list;
			result_attendance_information_department.map(o => o.title = o['department'])
	  			this.result_attendance_information_department = result_attendance_information_department
		 	}
		});
	},
	/**
	 * 获取employee_number
	 */
	get_salary_information_employee_number(){
		this.$get("~/api/salary_information/get_list?like=0", { page: 1, size: 10, "employee_number": this.query.word }, (json) => {
		  if (json.result) {
			var result_salary_information_employee_number = json.result.list;
			result_salary_information_employee_number.map(o => o.title = o['employee_number'])
	  			this.result_salary_information_employee_number = result_salary_information_employee_number
		 	}
		});
	},
	/**
	 * 获取full_name
	 */
	get_salary_information_full_name(){
		this.$get("~/api/salary_information/get_list?like=0", { page: 1, size: 10, "full_name": this.query.word }, (json) => {
		  if (json.result) {
			var result_salary_information_full_name = json.result.list;
			result_salary_information_full_name.map(o => o.title = o['full_name'])
	  			this.result_salary_information_full_name = result_salary_information_full_name
		 	}
		});
	},
	/**
	 * 获取department
	 */
	get_salary_information_department(){
		this.$get("~/api/salary_information/get_list?like=0", { page: 1, size: 10, "department": this.query.word }, (json) => {
		  if (json.result) {
			var result_salary_information_department = json.result.list;
			result_salary_information_department.map(o => o.title = o['department'])
	  			this.result_salary_information_department = result_salary_information_department
		 	}
		});
	},
	/**
	 * 获取employee_number
	 */
	get_resignation_information_employee_number(){
		this.$get("~/api/resignation_information/get_list?like=0", { page: 1, size: 10, "employee_number": this.query.word }, (json) => {
		  if (json.result) {
			var result_resignation_information_employee_number = json.result.list;
			result_resignation_information_employee_number.map(o => o.title = o['employee_number'])
	  			this.result_resignation_information_employee_number = result_resignation_information_employee_number
		 	}
		});
	},
	/**
	 * 获取full_name
	 */
	get_resignation_information_full_name(){
		this.$get("~/api/resignation_information/get_list?like=0", { page: 1, size: 10, "full_name": this.query.word }, (json) => {
		  if (json.result) {
			var result_resignation_information_full_name = json.result.list;
			result_resignation_information_full_name.map(o => o.title = o['full_name'])
	  			this.result_resignation_information_full_name = result_resignation_information_full_name
		 	}
		});
	},
	/**
	 * 获取department
	 */
	get_resignation_information_department(){
		this.$get("~/api/resignation_information/get_list?like=0", { page: 1, size: 10, "department": this.query.word }, (json) => {
		  if (json.result) {
			var result_resignation_information_department = json.result.list;
			result_resignation_information_department.map(o => o.title = o['department'])
	  			this.result_resignation_information_department = result_resignation_information_department
		 	}
		});
	},
	/**
	 * 获取employee_number
	 */
	get_reward_and_punishment_information_employee_number(){
		this.$get("~/api/reward_and_punishment_information/get_list?like=0", { page: 1, size: 10, "employee_number": this.query.word }, (json) => {
		  if (json.result) {
			var result_reward_and_punishment_information_employee_number = json.result.list;
			result_reward_and_punishment_information_employee_number.map(o => o.title = o['employee_number'])
	  			this.result_reward_and_punishment_information_employee_number = result_reward_and_punishment_information_employee_number
		 	}
		});
	},
	/**
	 * 获取full_name
	 */
	get_reward_and_punishment_information_full_name(){
		this.$get("~/api/reward_and_punishment_information/get_list?like=0", { page: 1, size: 10, "full_name": this.query.word }, (json) => {
		  if (json.result) {
			var result_reward_and_punishment_information_full_name = json.result.list;
			result_reward_and_punishment_information_full_name.map(o => o.title = o['full_name'])
	  			this.result_reward_and_punishment_information_full_name = result_reward_and_punishment_information_full_name
		 	}
		});
	},
	/**
	 * 获取department
	 */
	get_reward_and_punishment_information_department(){
		this.$get("~/api/reward_and_punishment_information/get_list?like=0", { page: 1, size: 10, "department": this.query.word }, (json) => {
		  if (json.result) {
			var result_reward_and_punishment_information_department = json.result.list;
			result_reward_and_punishment_information_department.map(o => o.title = o['department'])
	  			this.result_reward_and_punishment_information_department = result_reward_and_punishment_information_department
		 	}
		});
	},
	/**
	 * 获取types_of_rewards_and_punishments
	 */
	get_reward_and_punishment_information_types_of_rewards_and_punishments(){
		this.$get("~/api/reward_and_punishment_information/get_list?like=0", { page: 1, size: 10, "types_of_rewards_and_punishments": this.query.word }, (json) => {
		  if (json.result) {
			var result_reward_and_punishment_information_types_of_rewards_and_punishments = json.result.list;
			result_reward_and_punishment_information_types_of_rewards_and_punishments.map(o => o.title = o['types_of_rewards_and_punishments'])
	  			this.result_reward_and_punishment_information_types_of_rewards_and_punishments = result_reward_and_punishment_information_types_of_rewards_and_punishments
		 	}
		});
	},

  },
  components: { list_result_search },
	created(){
    this.query.word = this.$route.query.word || "";
  },
  mounted() {
	this.get_article();
		this.get_contract_information_employee_number();
		this.get_contract_information_full_name();
		this.get_contract_information_department();
		this.get_contract_information_contract_signing_date();
		this.get_employee_user_employee_number();
		this.get_employee_user_full_name();
		this.get_employee_user_department();
		this.get_training_information_name_of_training_subject();
		this.get_training_information_training_type();
		this.get_training_information_training_date();
		this.get_department_information_department_name();
		this.get_attendance_information_employee_number();
		this.get_attendance_information_full_name();
		this.get_attendance_information_department();
		this.get_salary_information_employee_number();
		this.get_salary_information_full_name();
		this.get_salary_information_department();
		this.get_resignation_information_employee_number();
		this.get_resignation_information_full_name();
		this.get_resignation_information_department();
		this.get_reward_and_punishment_information_employee_number();
		this.get_reward_and_punishment_information_full_name();
		this.get_reward_and_punishment_information_department();
		this.get_reward_and_punishment_information_types_of_rewards_and_punishments();
  },
  watch: {
	$route() {
	  $.push(this.query, this.$route.query);
	  this.get_article();
	  this.get_contract_information_employee_number();
	  this.get_contract_information_full_name();
	  this.get_contract_information_department();
	  this.get_contract_information_contract_signing_date();
	  this.get_employee_user_employee_number();
	  this.get_employee_user_full_name();
	  this.get_employee_user_department();
	  this.get_training_information_name_of_training_subject();
	  this.get_training_information_training_type();
	  this.get_training_information_training_date();
	  this.get_department_information_department_name();
	  this.get_attendance_information_employee_number();
	  this.get_attendance_information_full_name();
	  this.get_attendance_information_department();
	  this.get_salary_information_employee_number();
	  this.get_salary_information_full_name();
	  this.get_salary_information_department();
	  this.get_resignation_information_employee_number();
	  this.get_resignation_information_full_name();
	  this.get_resignation_information_department();
	  this.get_reward_and_punishment_information_employee_number();
	  this.get_reward_and_punishment_information_full_name();
	  this.get_reward_and_punishment_information_department();
	  this.get_reward_and_punishment_information_types_of_rewards_and_punishments();
	},
  },
};
</script>

<style scoped>
.card_search {
  text-align: center;
}
.card_result_search>.title {
  text-align: center;
  padding: 10px 0;
}
</style>
