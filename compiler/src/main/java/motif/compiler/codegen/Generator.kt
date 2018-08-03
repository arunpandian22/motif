package motif.compiler.codegen

import motif.cache.ExtCacheScope
import motif.ir.graph.Graph
import javax.annotation.processing.ProcessingEnvironment

class Generator(
        env: ProcessingEnvironment,
        private val graph: Graph) : CodegenCache(env, ExtCacheScope()) {

    private val scopeImplFactory = ScopeImplFactory(env, cacheScope, graph)

    fun generate() {
        graph.scopes.forEach {
            scopeImplFactory.create(it)
        }
    }
}