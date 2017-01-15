package com.questionnaire.michaelbabenkov.questionnaire.infrastructure.executors

import java.util.concurrent.*

/**
 * Created by michael.babenkov on 9/01/17.
 */
class JobExecutor : Executor {

    private val workQueue: BlockingQueue<Runnable>
    private val threadPoolExecutor: ThreadPoolExecutor
    private val threadFactory: ThreadFactory

    constructor() {
        workQueue = LinkedBlockingQueue<Runnable>()
        threadFactory = JobThreadFactory()
        threadPoolExecutor = ThreadPoolExecutor(INITIAL_POOL_SIZE, MAX_POOL_SIZE,
                KEEP_ALIVE_TIME.toLong(), KEEP_ALIVE_TIME_UNIT, this.workQueue, this.threadFactory)
    }

    override fun execute(command: Runnable) {
        threadPoolExecutor.execute(command)
    }

    private class JobThreadFactory : ThreadFactory {
        private var counter = 0

        override fun newThread(runnable: Runnable): Thread {
            return Thread(runnable, THREAD_NAME + counter++)
        }

        companion object {
            private val THREAD_NAME = "android_"
        }
    }

    companion object {
        //parallel calls should not be allowed
        private val INITIAL_POOL_SIZE = 1
        private val MAX_POOL_SIZE = 1
        private val KEEP_ALIVE_TIME = 10
        private val KEEP_ALIVE_TIME_UNIT = TimeUnit.SECONDS
    }
}