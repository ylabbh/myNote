<template>
	<h2 class="red">html的Dom内容{{msg}}</h2>
</template>

<script>
	/* 导出这个组件 */
	export default {
		/* 暴露给组件外部传参的一些参数 */
		props:{
			msg:{
				type:String,
				default : "msg的默认值，显然，这个msg是一个String类型而不是一个对象"
			}
		},
		
		/* 组件自己的一些方法 */
		methods:{
			
		},
		
		/* 组件内部使用的一些参数 */
		data():{
			return {
				
			}
		},
	}
</script>

<style>
	.red{color: #FF0000;}
</style>
