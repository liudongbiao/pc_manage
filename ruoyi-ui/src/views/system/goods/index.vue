<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="商品名称" prop="goodsName">
        <el-input
          v-model="queryParams.goodsName"
          placeholder="请输入商品名称"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="商品编号" prop="sn">
        <el-input
          v-model="queryParams.sn"
          placeholder="请输入商品编号"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="商品价格" prop="price">
        <el-input
          v-model="queryParams.price"
          placeholder="请输入商品价格"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="成本价格" prop="cost">
        <el-input
          v-model="queryParams.cost"
          placeholder="请输入成本价格"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="上架状态" prop="marketEnable">
        <el-select v-model="queryParams.marketEnable" placeholder="请选择上架状态" clearable>
          <el-option
            v-for="dict in dict.type.market_enable"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="积分" prop="point">
        <el-input
          v-model="queryParams.point"
          placeholder="请输入积分"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="创建时间" prop="createTime">
        <el-date-picker clearable
                        v-model="queryParams.createTime"
                        type="date"
                        value-format="yyyy-MM-dd"
                        placeholder="请选择创建时间">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="修改时间" prop="lastModify">
        <el-date-picker clearable
                        v-model="queryParams.lastModify"
                        type="date"
                        value-format="yyyy-MM-dd"
                        placeholder="请选择修改时间">
        </el-date-picker>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button
          type="primary"
          plain
          icon="el-icon-plus"
          size="mini"
          @click="handleAdd"
          v-hasPermi="['system:goods:add']"
        >新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          plain
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['system:goods:edit']"
        >修改</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          plain
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['system:goods:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['system:goods:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="goodsList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="商品名称" align="center" prop="goodsName" />
      <el-table-column label="商品编号" align="center" prop="sn" />
      <el-table-column label="商品价格" align="center" prop="price" />
      <el-table-column label="成本价格" align="center" prop="cost" />
      <el-table-column label="上架状态" align="center" prop="marketEnable">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.market_enable" :value="scope.row.marketEnable"/>
        </template>
      </el-table-column>
      <el-table-column label="积分" align="center" prop="point" />
      <el-table-column label="创建时间" align="center" prop="createTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.createTime) }}</span>
        </template>
      </el-table-column>
      <el-table-column label="修改时间" align="center" prop="lastModify" >
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.lastModify) }}</span>
        </template>
      </el-table-column>
      <el-table-column label="缩略图" align="center" prop="thumbnail" width="100">
        <template slot-scope="scope">
          <image-preview :src="scope.row.thumbnail" :width="50" :height="50"/>
        </template>
      </el-table-column>
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['system:goods:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['system:goods:remove']"
          >删除</el-button>
        </template>
      </el-table-column>
    </el-table>

    <pagination
      v-show="total>0"
      :total="total"
      :page.sync="queryParams.pageNum"
      :limit.sync="queryParams.pageSize"
      @pagination="getList"
    />

    <!-- 添加或修改商品对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="商品名称" prop="goodsName">
          <el-input v-model="form.goodsName" placeholder="请输入商品名称" />
        </el-form-item>
        <el-form-item label="商品编号" prop="sn">
          <el-input v-model="form.sn" placeholder="请输入商品编号" />
        </el-form-item>
        <el-form-item label="商品价格" prop="price">
          <el-input v-model="form.price" placeholder="请输入商品价格" />
        </el-form-item>
        <el-form-item label="成本价格" prop="cost">
          <el-input v-model="form.cost" placeholder="请输入成本价格" />
        </el-form-item>
        <el-form-item label="上架状态" prop="marketEnable">
          <el-select v-model="form.marketEnable" placeholder="请选择上架状态">
            <el-option
              v-for="dict in dict.type.market_enable"
              :key="dict.value"
              :label="dict.label"
              :value="dict.value"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="积分" prop="point">
          <el-input v-model="form.point" placeholder="请输入积分" />
        </el-form-item>
        <el-form-item label="缩略图" prop="thumbnail">
          <image-upload v-model="form.thumbnail"/>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
  import { listGoods, getGoods, delGoods, addGoods, updateGoods } from "@/api/system/goods";

  export default {
    name: "Goods",
    dicts: ['market_enable'],
    data() {
      return {
        // 遮罩层
        loading: true,
        // 选中数组
        ids: [],
        // 非单个禁用
        single: true,
        // 非多个禁用
        multiple: true,
        // 显示搜索条件
        showSearch: true,
        // 总条数
        total: 0,
        // 商品表格数据
        goodsList: [],
        // 弹出层标题
        title: "",
        // 是否显示弹出层
        open: false,
        // 查询参数
        queryParams: {
          pageNum: 1,
          pageSize: 10,
          goodsName: null,
          sn: null,
          price: null,
          cost: null,
          marketEnable: null,
          point: null,
          createTime: null,
          lastModify: null,
          thumbnail: null
        },
        // 表单参数
        form: {},
        // 表单校验
        rules: {
          goodsName: [
            { required: true, message: "商品名称不能为空", trigger: "blur" }
          ],
          sn: [
            { required: true, message: "商品编号不能为空", trigger: "blur" }
          ],
          price: [
            { required: true, message: "商品价格不能为空", trigger: "blur" }
          ],
          cost: [
            { required: true, message: "成本价格不能为空", trigger: "blur" }
          ],
          marketEnable: [
            { required: true, message: "上架状态不能为空", trigger: "change" }
          ],
        }
      };
    },
    created() {
      this.getList();
    },
    methods: {
      /** 查询商品列表 */
      getList() {
        this.loading = true;
        listGoods(this.queryParams).then(response => {
          this.goodsList = response.rows;
          this.total = response.total;
          this.loading = false;
        });
      },
      // 取消按钮
      cancel() {
        this.open = false;
        this.reset();
      },
      // 表单重置
      reset() {
        this.form = {
          goodsId: null,
          goodsName: null,
          sn: null,
          price: null,
          cost: null,
          marketEnable: "上架",
          point: null,
          createTime: null,
          lastModify: null,
          thumbnail: null
        };
        this.resetForm("form");
      },
      /** 搜索按钮操作 */
      handleQuery() {
        this.queryParams.pageNum = 1;
        this.getList();
      },
      /** 重置按钮操作 */
      resetQuery() {
        this.resetForm("queryForm");
        this.handleQuery();
      },
      // 多选框选中数据
      handleSelectionChange(selection) {
        this.ids = selection.map(item => item.goodsId)
        this.single = selection.length!==1
        this.multiple = !selection.length
      },
      /** 新增按钮操作 */
      handleAdd() {
        this.reset();
        this.open = true;
        this.title = "添加商品";
      },
      /** 修改按钮操作 */
      handleUpdate(row) {
        this.reset();
        const goodsId = row.goodsId || this.ids
        getGoods(goodsId).then(response => {
          this.form = response.data;
          this.open = true;
          this.title = "修改商品";
        });
      },
      /** 提交按钮 */
      submitForm() {
        this.$refs["form"].validate(valid => {
          if (valid) {
            if (this.form.goodsId != null) {
              updateGoods(this.form).then(response => {
                this.$modal.msgSuccess("修改成功");
                this.open = false;
                this.getList();
              });
            } else {
              addGoods(this.form).then(response => {
                this.$modal.msgSuccess("新增成功");
                this.open = false;
                this.getList();
              });
            }
          }
        });
      },
      /** 删除按钮操作 */
      handleDelete(row) {
        const goodsIds = row.goodsId || this.ids;
        this.$modal.confirm('是否确认删除商品编号为"' + goodsIds + '"的数据项？').then(function() {
          return delGoods(goodsIds);
        }).then(() => {
          this.getList();
          this.$modal.msgSuccess("删除成功");
        }).catch(() => {});
      },
      /** 导出按钮操作 */
      handleExport() {
        this.download('system/goods/export', {
          ...this.queryParams
        }, `goods_${new Date().getTime()}.xlsx`)
      }
    }
  };
</script>
